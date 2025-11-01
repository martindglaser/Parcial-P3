package com.example.parcialtp3.ui.screens.categories.saving

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.*
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.CategoryPanel
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.TravelSummaryBlock
import com.example.parcialtp3.ui.poppinsFamily

data class TravelExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun TravelScreen(
    navController: NavController? = null
) {
    val marchExpenses = listOf(
        TravelExpense("Tickets", "18:27 - March 30", "-$1,200.00"),
        TravelExpense("Hotel", "15:00 - March 24", "-$3,000.00"),
    )
    val februaryExpenses = listOf(
        TravelExpense("Suitcase", "12:30 - February 15", "-$250.00"),
    )

    BackgroundScaffold(
        headerHeight = 290.dp,
        headerColor = CaribbeanGreen,
        panelColor = Honeydew,
        headerContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                HeaderBar(
                    title = "Travel",
                    onBackClick = { navController?.popBackStack() },
                    onNotificationClick = { /* hacer*/ },

                )
                Spacer(modifier = Modifier.height(12.dp))

                TravelSummaryBlock(modifier = Modifier.padding(horizontal = 20.dp))
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
                iconResId = R.drawable.vector_gift,
                onAddExpense = {
                    navController?.navigate("travel/addExpense")
                }
            )
        }
    )
}