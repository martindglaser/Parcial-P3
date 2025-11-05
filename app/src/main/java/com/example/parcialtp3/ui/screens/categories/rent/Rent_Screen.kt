package com.example.parcialtp3.ui.screens.categories.rent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.CategoryPanel
import com.example.parcialtp3.ui.components.FinanceSummaryBlock
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.MonthlyExpenseGroup

data class RentExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun RentScreen(
    navController: NavHostController
) {
    val aprilExpenses = listOf(
        RentExpense("Rent", "18:27 - April 15", "-$674,40")
    )
    val marchExpenses = listOf(
        RentExpense("Rent", "15:00 - March 15", "-$674,40")
    )
    val februaryExpenses = listOf(
        RentExpense("Rent", "11:47 - February 15", "-$674,40")
    )
    val januaryExpenses = listOf(
        RentExpense("Rent", "18:50 - January 15", "-$674,40")
    )

    val allMonthlyExpenses = listOf(
        MonthlyExpenseGroup("April", aprilExpenses),
        MonthlyExpenseGroup("March", marchExpenses),
        MonthlyExpenseGroup("February", februaryExpenses),
        MonthlyExpenseGroup("January", januaryExpenses)
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
                    title = "Rent",
                    navController = navController
                )
                Spacer(modifier = Modifier.height(24.dp))
                FinanceSummaryBlock()
            }
        },
        panelContent = {
            CategoryPanel(
                monthlyExpenses = allMonthlyExpenses,
                iconResId = R.drawable.vector_rent,
                onAddExpense = {
                    navController?.navigate("rent/addExpense")
                },
                expenseData = { expense ->
                    Triple(expense.title, expense.time, expense.amount)
                }
            )
        }
    )
}