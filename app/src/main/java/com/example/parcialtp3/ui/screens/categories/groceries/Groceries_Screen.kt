package com.example.parcialtp3.ui.screens.categories.groceries

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.*
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.CategoryPanel
import com.example.parcialtp3.ui.components.FinanceSummaryBlock
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.poppinsFamily

data class GroceriesExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun GroceriesScreen(
    navController: NavHostController
) {
    val marchExpenses = listOf(
        GroceriesExpense("Groceries", "18:27 - March 30", "-$26,00"),
        GroceriesExpense("Groceries", "15:00 - March 24", "-$18,35"),
        GroceriesExpense("Groceries", "12:30 - March 15", "-$15,40"),
        GroceriesExpense("Groceries", "9:30 - March 08", "-$12,13"),
    )

    val februaryExpenses = listOf(
        GroceriesExpense("Groceries", "20:50 - February 28", "-$27,20")
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
                    navController = navController,
                    onBackClick = { navController.popBackStack() },
                    onNotificationClick = { navController.navigate("notifications") }
                )
                Spacer(modifier = Modifier.height(24.dp))
                FinanceSummaryBlock()
            }
        },
        panelContent = {
            CategoryPanel(
                month1Name = "March",
                month1Expenses = marchExpenses,
                month2Name = "February",
                month2Expenses = februaryExpenses,
                title = { it.title },
                time = { it.time },
                amount = { it.amount },
                iconResId = R.drawable.vector_groceries,
                onAddExpense = {
                    navController.navigate("groceries/addExpense")
                }
            )
        }
    )
}
