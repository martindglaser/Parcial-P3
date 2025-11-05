package com.example.parcialtp3.ui.screens.categories.entertainment

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
import com.example.parcialtp3.ui.*
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.FinanceSummaryBlock
import com.example.parcialtp3.ui.components.HeaderBar
// NUEVOS IMPORTS
import com.example.parcialtp3.ui.components.CategoryPanel
import com.example.parcialtp3.ui.components.MonthlyExpenseGroup

data class EntertainmentExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun A_Entertainment_Screen(
    navController: NavHostController
) {
    val aprilExpenses = listOf(
        EntertainmentExpense("Cinema", "20:15 - April 29", "-$30,00"),
        EntertainmentExpense("Netflix", "16:15 - April 12", "-$12,27"),
        EntertainmentExpense("Karaoke", "18:00 - April 05", "-$10,00"),
    )
    val marchExpenses = listOf(
        EntertainmentExpense("Video Game", "20:50 - March 24", "-$60,20"),
        EntertainmentExpense("Netflix", "16:15 - March 12", "-$12,27"),
    )

    // 1. Agrupa tus datos en la nueva data class
    val allMonthlyExpenses = listOf(
        MonthlyExpenseGroup("April", aprilExpenses),
        MonthlyExpenseGroup("March", marchExpenses)
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
                    title = "Entertainment",
                    navController = navController
                )
                Spacer(modifier = Modifier.height(24.dp))
                FinanceSummaryBlock()
            }
        },
        panelContent = {
            // 2. Llama al nuevo CategoryPanel
            CategoryPanel(
                monthlyExpenses = allMonthlyExpenses,
                iconResId = R.drawable.vector_enter,
                onAddExpense = {
                    navController?.navigate("entertainment/addExpense")
                },
                // 3. Dile al panel cómo leer tus datos
                expenseData = { expense ->
                    Triple(expense.title, expense.time, expense.amount)
                }
            )
        }
    )
}
