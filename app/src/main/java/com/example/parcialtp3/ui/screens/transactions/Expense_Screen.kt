package com.example.parcialtp3.ui.screens.transactions

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.OceanBlue
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.*
import com.example.parcialtp3.ui.viewmodels.TransactionsViewModel


@Composable
fun TransactionsExpenseScreen(navController: NavHostController) {
    val viewModel: TransactionsViewModel = viewModel()

        BackgroundScaffold(
            navController = navController,
            headerHeight = 410.dp,
            whiteHeight = Dp.Unspecified,
            headerContent = { TransactionsExpenseHeader(navController) },
            panelContent = {
                TransactionsMonthSection(viewModel = viewModel, typeFilter = "expense")
            }
        )

}

@Composable
fun TransactionsExpenseHeader(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderBar(
            title = "Transaction",
            navController = navController,
            onBackClick = { navController.popBackStack() }
        )

        CabeceraTransactions(
            tarjetaBalanceText1 = "Total Balance",
            tarjetaBalanceText2 = "$7,783.00",
            tarjeta1Color = Honeydew,
            tarjeta1Imagen = R.drawable.group_395,
            tarjeta1Direccion = "Income_Screen",
            tarjeta1Texto1 = "Income",
            tarjeta1Texto2 = "$4,120.00",
            tarjeta1Texto1Color = Void,
            tarjeta1Texto2Color = Void,
            tarjeta2Direccion = "Tranasctions_Screen",
            tarjeta2Color = OceanBlue,
            tarjeta2Imagen = R.drawable.group_396_white,
            tarjeta2Texto1 = "Expense",
            tarjeta2Texto2 = "$1,187.40",
            tarjeta2Texto1Color = Honeydew,
            tarjeta2Texto2Color = Honeydew,
            navController = navController
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}
