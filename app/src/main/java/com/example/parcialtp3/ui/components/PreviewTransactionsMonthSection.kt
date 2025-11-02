package com.example.parcialtp3.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3.ui.OceanBlue
import com.example.parcialtp3.ui.screens.transactions.TransactionsViewModel
import com.example.parcialtp3.R
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import com.example.parcialtp3.data.remote.model.TransactionsResponse
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.data.remote.RetrofitClient.api


@Composable
fun TransactionsMonthSection(viewModel: TransactionsViewModel = viewModel()) {
    val grouped by viewModel.transactionsByMonth.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadTransactions()
    }

    if (grouped.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("No se encontraron transacciones", color = OceanBlue)
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            grouped.forEach { (monthName, transactions) ->
                item {
                    MonthSection(
                        monthName = monthName,
                        transactions = transactions.map { map ->
                            Transaction(
                                iconRes = R.drawable.icon_salary,
                                title = map["description"]?.toString() ?: "Sin descripción",
                                subtitle = map["date"]?.toString() ?: "",
                                middleText = if (map["type"] == "credit") "Income" else "Expense",
                                value = "$${map["amount"]},00",
                                valueColor = if (map["type"] == "credit") OceanBlue else Void
                            )
                        }
                    )
                }
            }
        }
    }
}

