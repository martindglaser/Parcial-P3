package com.example.parcialtp3.ui.screens.transactions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.OceanBlue
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.CabeceraTransactions
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.MonthSection
import com.example.parcialtp3.ui.components.Transaction
import com.example.parcialtp3.ui.poppinsFamily

@Composable
fun TransactionsIncomeScreen() {
    BackgroundScaffold(
        headerHeight = 410.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = { TransactionsIncomeHeader() },
        panelContent = { PreviewTransactionsIncomeMonthSection() }
    )
}

@Composable
fun TransactionsIncomeHeader() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderBar("Transaction")
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



@Preview(showBackground = true)
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
        item {
            MonthSection(monthName = "April", transactions = aprilTransactions)
        }
        item {
            MonthSection(monthName = "March", transactions = marchTransactions)
        }
        item {
            MonthSection(monthName = "February", transactions = februaryTransactions)
        }
    }
}

