package com.example.parcialtp3.ui.screens.categories.gifts

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

data class GiftExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun GiftsScreen(
    navController: NavHostController
) {
    val aprilExpenses = listOf(
        GiftExpense("Perfume", "10:27 - April 28", "-$30,00"),
        GiftExpense("Make-Up", "16:28 - April 15", "-$60,35")
    )
    val marchExpenses = listOf(
        GiftExpense("Teddy Bear", "8:30 - March 10", "-$20,00"),
        GiftExpense("Cooking Lessons", "14:24 - March 02", "-$128,00")
    )
    val februaryExpenses = listOf(
        GiftExpense("Toys For Dani", "11:15 - February 18", "-$50,20")
    )

    val allMonthlyExpenses = listOf(
        MonthlyExpenseGroup("April", aprilExpenses),
        MonthlyExpenseGroup("March", marchExpenses),
        MonthlyExpenseGroup("February", februaryExpenses)
    )

    BackgroundScaffold(
        navController = navController,
        headerHeight = 290.dp,
        headerContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                HeaderBar(
                    title = "Gifts",
                    navController = navController,
                    onBackClick = { navController.popBackStack() }
                )
                Spacer(modifier = Modifier.height(24.dp))
                FinanceSummaryBlock()
            }
        },
        panelContent = {
            CategoryPanel(
                monthlyExpenses = allMonthlyExpenses,
                iconResId = R.drawable.vector_gift,
                onAddExpense = {
                    navController?.navigate("gifts/addExpense")
                },
                expenseData = { expense ->
                    Triple(expense.title, expense.time, expense.amount)
                }
            )
        }
    )
}