package com.example.parcialtp3.ui.screens.transaction

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.FinanceSummaryBlock
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.TarjetaBalance
import com.example.parcialtp3.ui.components.TransactionsMonthSection
import com.example.parcialtp3.ui.viewmodels.TransactionsViewModel


@Composable
fun TransactionScreen(
    navController: NavHostController
) {
    val viewModel: TransactionsViewModel = viewModel()

    BackgroundScaffold(
        navController = navController,
        headerHeight = 410.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            TransactionHeader(navController)
        },
        panelContent = {
            TransactionsMonthSection(viewModel = viewModel)
        },
    )
}

@Composable
fun TransactionHeader(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderBar(
            title = "Transaction",
            navController = navController,
            onBackClick = { navController.popBackStack() }
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