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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import com.example.parcialtp3.ui.poppinsFamily

@Composable
fun Transactions_Screen() {
    BackgroundScaffold(
        headerHeight = 380.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = { Transactions_Header() },
        panelContent = { PreviewMonthSection() }
    )
}

@Composable
fun Transactions_Header() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderBar("Transaction")
        Cabecera()
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun TransactionItem(
    @androidx.annotation.DrawableRes iconRes: Int,
    title: String,
    subtitle: String,
    middleText: String,
    value: String,
    valueColor: Color,
    separatorColor: Color = Void
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // ─────────────── Primera columna (50%) ───────────────
        Row(
            modifier = Modifier
                .weight(0.5f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(Color.Transparent, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = iconRes),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(Modifier.width(10.dp))

            Column {
                Text(
                    text = title,
                    fontSize = 15.sp,
                    color = Void,
                    fontFamily = poppinsFamily
                )
                Text(
                    text = subtitle,
                    fontSize = 13.sp,
                    color = OceanBlue,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = poppinsFamily
                )
            }
        }

        // ─────────────── Separador 1 ───────────────
        Box(
            modifier = Modifier
                .width(1.dp)
                .height(30.dp)
                .background(separatorColor)
        )

        // ─────────────── Segunda columna (25%) ───────────────
        Box(
            modifier = Modifier
                .weight(0.25f)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = middleText,
                fontSize = 16.sp,
                color = Void,
                fontFamily = poppinsFamily
            )
        }

        // ─────────────── Separador 2 ───────────────
        Box(
            modifier = Modifier
                .width(1.dp)
                .height(30.dp)
                .background(separatorColor)
        )

        // ─────────────── Tercera columna (25%) ───────────────
        Box(
            modifier = Modifier
                .weight(0.25f)
                .fillMaxHeight(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = value,
                color = valueColor,
                fontSize = 18.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.W500
            )
        }
    }
}


@Composable
fun HeaderBar(
    title: String,
    onBackClick: (() -> Unit)? = null,
    onNotificationClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(CaribbeanGreen) // tu color de fondo verde
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(id = R.drawable.bring_back),
            contentDescription = "Back",
            modifier = Modifier
                .size(24.dp)
                .clickable { onBackClick?.invoke() },
            contentScale = ContentScale.Fit
        )

        Text(
            text = title,
            color = Void,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = poppinsFamily,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )

        Box(
            modifier = Modifier
                .size(32.dp)
                .background(Color(0xFFE9FFF6), CircleShape)
                .clickable { onNotificationClick?.invoke() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_notification),
                contentDescription = "Notifications",
                modifier = Modifier.size(20.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}




data class Transaction(
    val iconRes: Int,
    val title: String,
    val subtitle: String,
    val middleText: String,
    val value: String,
    val valueColor: Color
)

@Composable
fun MonthSection(monthName: String, transactions: List<Transaction>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        Text(
            text = monthName,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )

        // LazyColumn para que se muestren todas las filas
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 600.dp) // se ajusta según tu layout
        ) {
            items(transactions) { t ->
                TransactionItem(
                    iconRes = t.iconRes,
                    title = t.title,
                    subtitle = t.subtitle,
                    middleText = t.middleText,
                    value = t.value,
                    valueColor = t.valueColor
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewMonthSection() {
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

@Composable
fun TarjetaBalance(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    text1: String,
    text2: String
) {
    Column(modifier.padding(horizontal = 8.dp, vertical = 16.dp)) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = backgroundColor)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = text1,
                    color = Void,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    fontFamily = poppinsFamily
                )
                Text(
                    text = text2,
                    color = Void,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    fontFamily = poppinsFamily
                )
            }
        }
    }
}

@Composable
fun TarjetasIncomeExpense(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    imageResId: Int,
    text1: String,
    text2: String,
    text1Color: Color = MaterialTheme.colorScheme.onSurface,
    text2Color: Color = Color.Gray
) {
    Column(modifier.padding(horizontal = 8.dp, vertical = 8.dp)) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = backgroundColor)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = text1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = text1,
                    color = text1Color,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    fontFamily = poppinsFamily
                )
                Text(
                    text = text2,
                    color = text2Color,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    fontFamily = poppinsFamily
                )
            }
        }
    }
}

@Composable
fun Cabecera(modifier: Modifier = Modifier) {
    Column(Modifier.padding(15.dp, 0.dp)) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TarjetaBalance(
                backgroundColor = Honeydew,
                text1 = "Total Balance",
                text2 = "7,783.00"
            )
        }
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.weight(1f)) {
                TarjetasIncomeExpense(
                    backgroundColor = Color.White,
                    imageResId = R.drawable.group_395,
                    text1 = "Income",
                    text2 = "4,120.00",
                    text1Color = Color.Black,
                    text2Color = Color.Black
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                TarjetasIncomeExpense(
                    backgroundColor = Color.White,
                    imageResId = R.drawable.group_396,
                    text1 = "Expense",
                    text2 = "1,187.40",
                    text1Color = Color.Black,
                    text2Color = OceanBlue
                )
            }
        }
    }
}
