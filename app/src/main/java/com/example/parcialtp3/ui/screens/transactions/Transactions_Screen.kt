package com.example.parcialtp3.ui.screens.transactions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.CabeceraTransactions
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.TransactionsMonthSection
import com.example.parcialtp3.ui.viewmodels.TransactionsViewModel


@Composable
fun Transactions_Screen(navController: NavHostController) {
    val viewModel: TransactionsViewModel = viewModel()
        BackgroundScaffold(
            current = "Tranasctions_Screen",
            navController = navController,
            headerHeight = 410.dp,
            whiteHeight = Dp.Unspecified,
            headerContent = { Transactions_Header(navController) },
            panelContent = {
                TransactionsMonthSection(viewModel = viewModel)
            }
        )
}

@Composable
fun Transactions_Header(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderBar(
            title = "Transaction",
            navController = navController,
            onBackClick = { navController.popBackStack() }
        )

        CabeceraTransactions(
            navController = navController,
            tarjetaBalanceText1 = "Total Balance",
            tarjetaBalanceText2 = "$7,783.00",
            tarjeta1Direccion = "Income_Screen",
            tarjeta1Color = Honeydew,
            tarjeta1Imagen = R.drawable.group_395,
            tarjeta1Texto1 = "Income",
            tarjeta1Texto2 = "$4,120.00",
            tarjeta1Texto1Color = Void,
            tarjeta1Texto2Color = Void,
            tarjeta2Direccion = "Expense_Screen",
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
