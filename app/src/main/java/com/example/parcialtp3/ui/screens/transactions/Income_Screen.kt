package com.example.parcialtp3.ui.screens.transactions

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.OceanBlue
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.*

@Composable
fun TransactionsIncomeScreen(navController: NavHostController) {  // ✅ ahora recibe navController
    Scaffold(
        bottomBar = { BottomNavBar(navController, current = "transactions") }
    ) { paddingValues ->
        BackgroundScaffold(
            headerHeight = 410.dp,
            whiteHeight = Dp.Unspecified,
            headerContent = { TransactionsIncomeHeader(navController) }, // ✅ se lo pasamos
            panelContent = { PreviewTransactionsIncomeMonthSection() },
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun TransactionsIncomeHeader(navController: NavHostController) {  // ✅ también lo recibe
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderBar(
            title = "Transaction",
            navController = navController, // ✅ lo pasamos al HeaderBar
            onBackClick = { navController.popBackStack() }
        )

        CabeceraTransactions(
            tarjetaBalanceText1 = "Total Balance",
            tarjetaBalanceText2 = "$7,783.00",
            tarjeta1Color = OceanBlue,
            tarjeta1Imagen = R.drawable.group_395_white,
            tarjeta1Texto1 = "Income",
            tarjeta1Texto2 = "$4,120.00",
            tarjeta1Texto1Color = Honeydew,
            tarjeta1Texto2Color = Honeydew,
            tarjeta2Color = Honeydew,
            tarjeta2Imagen = R.drawable.group_396,
            tarjeta2Texto1 = "Expense",
            tarjeta2Texto2 = "$1,187.40",
            tarjeta2Texto1Color = Void,
            tarjeta2Texto2Color = OceanBlue
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun PreviewTransactionsIncomeMonthSection() {
    val aprilTransactions = listOf(
        Transaction(
            iconRes = R.drawable.icon_salary,
            title = "Salary",
            subtitle = "18:27 - April 30",
            middleText = "Monthly",
            value = "$4.000,00",
            valueColor = Void
        ),
        Transaction(
            iconRes = R.drawable.icon_salary,
            title = "Others",
            subtitle = "17:00 - April 24",
            middleText = "Payments",
            value = "$120,00",
            valueColor = Void
        )
    )

    val marchTransactions = listOf(
        Transaction(
            iconRes = R.drawable.icon_salary,
            title = "Salary",
            subtitle = "19:39 - March 31",
            middleText = "Monthly",
            value = "4.000,00",
            valueColor = Void
        ),
        Transaction(
            iconRes = R.drawable.icon_salary,
            title = "Others",
            subtitle = "09:30 - April 12",
            middleText = "Upwork",
            value = "$340,00",
            valueColor = Void
        )
    )

    val februaryTransactions = listOf(
        Transaction(
            iconRes = R.drawable.icon_salary,
            title = "Salary",
            subtitle = "19:30 - March 31",
            middleText = "Upwork",
            value = "340,00",
            valueColor = Void
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        item { MonthSection(monthName = "April", transactions = aprilTransactions) }
        item { MonthSection(monthName = "March", transactions = marchTransactions) }
        item { MonthSection(monthName = "February", transactions = februaryTransactions) }
    }
}
