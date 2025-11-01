package com.example.parcialtp3.ui.screens.categories.transport

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


data class TransportExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun TransportScreen(
    navController: NavController? = null
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
                    onNotificationClick = { /* hacer*/ }
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
                title = { it.title }, // it -> TransportExpense
                time = { it.time },
                amount = { it.amount },
                iconResId = R.drawable.vector_transport,
                onAddExpense = {
                    navController?.navigate("transport/addExpense")
                }
            )
        }
    )
}

