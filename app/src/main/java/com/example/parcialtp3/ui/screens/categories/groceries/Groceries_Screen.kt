package com.example.parcialtp3.ui.screens.categories.groceries

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.CategoryPanel
import com.example.parcialtp3.ui.components.FinanceSummaryBlock
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.MonthlyExpenseGroup

data class GroceriesExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun GroceriesScreen(
    navController: NavController? = null
) {
    val marchExpenses = listOf(
        GroceriesExpense("Pantry", "17:00 - March 24", "-$26,00"),
        GroceriesExpense("Snacks", "17:02 - March 24", "-$18,35")
    )
    val februaryExpenses = listOf(
        GroceriesExpense("Canned Food", "18:30 - February 28", "-$15,40"),
        GroceriesExpense("Veeggies", "18:31 - February 28", "-$12,13"),
        GroceriesExpense("Groceries", "18:31 - February 28", "-$27,20")
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
                    title = "Groceries",
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
                iconResId = R.drawable.vector_groceries,
                onAddExpense = {
                    navController?.navigate("groceries/addExpense")
                },
                expenseData = { expense ->
                    Triple(expense.title, expense.time, expense.amount)
                }
            )
        }
    )
}