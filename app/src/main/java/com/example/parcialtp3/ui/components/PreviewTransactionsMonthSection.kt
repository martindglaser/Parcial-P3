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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.Cyprus
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.OceanBlue
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.screens.profile.ThemeViewModel
import com.example.parcialtp3.ui.viewmodels.TransactionsViewModel


@Composable
fun TransactionsMonthSection(
    viewModel: TransactionsViewModel = viewModel(),
    typeFilter: String? = null
) {
    val themeViewModel: ThemeViewModel = viewModel()
    val isDarkMode = themeViewModel.darkThemeEnabled.collectAsState().value



    val grouped by viewModel.transactionsByMonth.collectAsState()

    LaunchedEffect(typeFilter) {
        viewModel.loadTransactions(typeFilter)
    }

    val groupedToShow = if (typeFilter.isNullOrBlank()) {
        grouped
    } else {
        grouped.mapValues { entry ->
            entry.value.filter { it["type"] == typeFilter }
        }.filterValues { it.isNotEmpty() }
    }

    if (groupedToShow.isEmpty()) {
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
            groupedToShow.forEach { (monthName, transactions) ->
                item {
                    MonthSection(
                        monthName = monthName,
                        transactions = transactions.map { map ->
                            Transaction(
                                iconRes = R.drawable.icon_salary,
                                title = map["description"]?.toString() ?: "Sin descripción",
                                subtitle = map["date"]?.toString() ?: "",
                                middleText = map["subtype"]?.toString() ?: "",
                                value = "$${map["amount"]}",
                                valueColor = if (map["type"] == "income") OceanBlue else if(isDarkMode) LightGreen else Void
                            )
                        }
                    )
                }
            }
        }
    }
}
