package com.example.parcialtp3.ui.screens.transactions

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.material3.Scaffold
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.OceanBlue
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.*

@Composable
fun TransactionsExpenseScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomNavBar(navController, current = "transactions") }
    ) { paddingValues ->
        BackgroundScaffold(
            headerHeight = 410.dp,
            whiteHeight = Dp.Unspecified,
            headerContent = { TransactionsExpenseHeader() },
            panelContent = { PreviewTransactionsExpenseMonthSection() },
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun TransactionsExpenseHeader() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderBar("Transaction")
        CabeceraTransactions(
            tarjetaBalanceText1 = "Total Balance",
            tarjetaBalanceText2 = "$7,783.00",
            tarjeta1Color = Honeydew,
            tarjeta1Imagen = R.drawable.group_395,
            tarjeta1Texto1 = "Income",
            tarjeta1Texto2 = "$4,120.00",
            tarjeta1Texto1Color = Void,
            tarjeta1Texto2Color = Void,
            tarjeta2Color = OceanBlue,
            tarjeta2Imagen = R.drawable.group_396_white,
            tarjeta2Texto1 = "Expense",
            tarjeta2Texto2 = "$1,187.40",
            tarjeta2Texto1Color = Honeydew,
            tarjeta2Texto2Color = Honeydew
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun PreviewTransactionsExpenseMonthSection() {
    val aprilTransactions = listOf(
        Transaction(
            iconRes = R.drawable.icon_groceries,
            title = "Groceries",
            subtitle = "17:00 - April 24",
            middleText = "Pantry",
            value = "-$100,00",
            valueColor = OceanBlue
        ),
        Transaction(
            iconRes = R.drawable.icon_rent,
            title = "Rent",
            subtitle = "8:30 - April 15",
            middleText = "Rent",
            value = "-$674,40",
            valueColor = OceanBlue
        ),
        Transaction(
            iconRes = R.drawable.icon_transport,
            title = "Transport",
            subtitle = "7:30 - April 08",
            middleText = "Fuel",
            value = "-$4,13",
            valueColor = OceanBlue
        )
    )

    val marchTransactions = listOf(
        Transaction(
            iconRes = R.drawable.icon_food,
            title = "Food",
            subtitle = "19:30 - March 31",
            middleText = "Dinner",
            value = "-$70,40",
            valueColor = OceanBlue
        ),
        Transaction(
            iconRes = R.drawable.icon_rent,
            title = "Rent",
            subtitle = "18:39 - March 31",
            middleText = "Rent",
            value = "-$674,40",
            valueColor = OceanBlue
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        item { MonthSection(monthName = "April", transactions = aprilTransactions) }
        item { MonthSection(monthName = "March", transactions = marchTransactions) }
    }
}
