package com.example.parcialtp3.ui.screens.categories.medicine

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

data class MedicineExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun A_Medicine_Screen(
    navController: NavHostController
) {
    val aprilExpenses = listOf(
        MedicineExpense("Acetaminophen", "18:27 - April 30", "-$2,00")
    )
    val marchExpenses = listOf(
        MedicineExpense("Vitamin C", "15:00 - March 30", "-$1,00"),
        MedicineExpense("Muscle Pain Cream", "12:47 - March 10", "-$0,50")
    )
    val februaryExpenses = listOf(
        MedicineExpense("Aspirin", "9:50 - February 09", "-$3,00")
    )

    val allMonthlyExpenses = listOf(
        MonthlyExpenseGroup("April", aprilExpenses),
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
                    title = "Medicine",
                    navController = navController
                )
                Spacer(modifier = Modifier.height(24.dp))
                FinanceSummaryBlock()
            }
        },
        panelContent = {
            CategoryPanel(
                monthlyExpenses = allMonthlyExpenses,
                iconResId = R.drawable.vector_medicine,
                onAddExpense = {
                    navController?.navigate("medicine/addExpense")
                },
                expenseData = { expense ->
                    Triple(expense.title, expense.time, expense.amount)
                }
            )
        }
    )
}