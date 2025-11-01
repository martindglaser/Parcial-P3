package com.example.parcialtp3.ui.screens.categories.food


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.*
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.CategoryPanel
import com.example.parcialtp3.ui.components.FinanceSummaryBlock
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.poppinsFamily


data class FoodExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun FoodScreen(
    navController: NavController? = null
) {
    val aprilExpenses = listOf(
        FoodExpense("Dinner", "18:27 - April 30", "-$26,00"),
        FoodExpense("Delivery Pizza", "15:00 - April 24", "-$18,35"),
        FoodExpense("Lunch", "12:30 - April 15", "-$15,40"),
        FoodExpense("Brunch", "9:30 - April 08", "-$12,13"),
    )
    val marchExpenses = listOf(
        FoodExpense("Dinner", "20:50 - March 31", "-$27,20")
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
                    title = "Food",
                    onBackClick = { navController?.popBackStack() },
                    onNotificationClick = { /* hacer*/ }
                )
                Spacer(modifier = Modifier.height(24.dp))
                FinanceSummaryBlock()
            }
        },
        panelContent = {

            CategoryPanel(
                month1Name = "April",
                month1Expenses = aprilExpenses,
                month2Name = "March",
                month2Expenses = marchExpenses,
                title = { it.title }, // it -> FoodExpense
                time = { it.time },
                amount = { it.amount },
                iconResId = R.drawable.vector_food,
                onAddExpense = {
                    //  navController?.navigate("food/addExpense")
                }
            )
        }
    )
}

