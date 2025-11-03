package com.example.parcialtp3.ui.screens.categories.transport

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.CategoryPanel
import com.example.parcialtp3.ui.components.FinanceSummaryBlock
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.MonthlyExpenseGroup

data class TransportExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun TransportScreen(
    navController: NavHostController
) {
    val marchExpenses = listOf(
        TransportExpense("Fuel", "18:27 - March 30", "-$3.53"),
        TransportExpense("Car Parts", "15:00 - March 30", "-$28.75")
    )
    val februaryExpenses = listOf(
        TransportExpense("New Tires", "12:47 - February 10", "-$373.99"),
        TransportExpense("Car Wash", "9:50 - February 09", "-$9.74"),
        TransportExpense("Public Transport", "7:50 - February 01", "-$1.24")
    )

    val allMonthlyExpenses = listOf(
        MonthlyExpenseGroup("March", marchExpenses),
        MonthlyExpenseGroup("February", februaryExpenses)
    )

    BackgroundScaffold(
        headerHeight = 290.dp,
        headerColor = CaribbeanGreen,
        panelColor = Honeydew,
        headerContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                HeaderBar(
                    title = "Transport",
                    onBackClick = { navController?.popBackStack() },
                    onNotificationClick = { }
                )
                Spacer(modifier = Modifier.height(24.dp))
                FinanceSummaryBlock()
            }
        },
        panelContent = {
            CategoryPanel(
                monthlyExpenses = allMonthlyExpenses,
                iconResId = R.drawable.vector_transport,
                onAddExpense = {
                    navController?.navigate("transport/addExpense")
                },
                expenseData = { expense ->
                    Triple(expense.title, expense.time, expense.amount)
                }
            )
        }
    )
}
