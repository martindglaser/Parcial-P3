package com.example.parcialtp3.ui.screens.transaction

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.*
import com.example.parcialtp3.ui.components.*

@Composable
fun TransactionScreen(
    navController: NavHostController
) {
    BackgroundScaffold(
        headerHeight = 410.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            TransactionHeader(navController)
        },
        panelContent = {
            PreviewMonthSection()
        }
    )
}

@Composable
fun TransactionHeader(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderBar(
            title = "Transactions",
            navController = navController,
            onBackClick = { navController.popBackStack() },
            onNotificationClick = { navController.navigate("notifications") }
        )

        TarjetaBalance(
            backgroundColor = Honeydew,
            text1 = "Total Balance",
            text2 = "$7,783.00"
        )

        FinanceSummaryBlock()
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun PreviewMonthSection() {
    val aprilTransactions = listOf(
        Transaction(
            iconRes = R.drawable.icon_salary,
            title = "Salary",
            subtitle = "18:27 - April 30",
            middleText = "Monthly",
            value = "$4,000.00",
            valueColor = Void
        ),
        Transaction(
            iconRes = R.drawable.icon_groceries,
            title = "Groceries",
            subtitle = "17:00 - April 24",
            middleText = "Pantry",
            value = "-$100.00",
            valueColor = OceanBlue
        ),
        Transaction(
            iconRes = R.drawable.icon_rent,
            title = "Rent",
            subtitle = "8:30 - April 15",
            middleText = "Rent",
            value = "-$674.40",
            valueColor = OceanBlue
        ),
        Transaction(
            iconRes = R.drawable.icon_transport,
            title = "Transport",
            subtitle = "7:30 - April 08",
            middleText = "Fuel",
            value = "-$4.13",
            valueColor = OceanBlue
        )
    )

    val marchTransactions = listOf(
        Transaction(
            iconRes = R.drawable.icon_food,
            title = "Food",
            subtitle = "19:30 - March 31",
            middleText = "Dinner",
            value = "-$70.40",
            valueColor = OceanBlue
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        item {
            MonthSection(monthName = "April", transactions = aprilTransactions)
        }
        item {
            MonthSection(monthName = "March", transactions = marchTransactions)
        }
    }
}
