package com.example.parcialtp3.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.OceanBlue
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.poppinsFamily


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
data class Transaction(
    val iconRes: Int,
    val title: String,
    val subtitle: String,
    val middleText: String,
    val value: String,
    val valueColor: Color
)

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
fun CabeceraTransactions(
    modifier: Modifier = Modifier,
    tarjetaBalanceText1: String,
    tarjetaBalanceText2: String,
    tarjeta1Color: Color,
    tarjeta1Imagen: Int,
    tarjeta1Texto1: String,
    tarjeta1Texto2: String,
    tarjeta1Texto1Color: Color,
    tarjeta1Texto2Color: Color,
    tarjeta2Color: Color,
    tarjeta2Imagen: Int,
    tarjeta2Texto1: String,
    tarjeta2Texto2: String,
    tarjeta2Texto1Color: Color,
    tarjeta2Texto2Color: Color
    ) {
    Column(Modifier.padding(15.dp, 0.dp)) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TarjetaBalance(
                backgroundColor = Honeydew,
                text1 = tarjetaBalanceText1,
                text2 = tarjetaBalanceText2
            )
        }
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.weight(1f)) {
                TarjetasIncomeExpense(
                    backgroundColor = tarjeta1Color,
                    imageResId = tarjeta1Imagen,
                    text1 = tarjeta1Texto1,
                    text2 = tarjeta1Texto2,
                    text1Color = tarjeta1Texto1Color,
                    text2Color = tarjeta1Texto2Color
                )
            }
            Box(modifier = Modifier.weight(1f)) {
                TarjetasIncomeExpense(
                    backgroundColor = tarjeta2Color,
                    imageResId = tarjeta2Imagen,
                    text1 = tarjeta2Texto1,
                    text2 = tarjeta2Texto2,
                    text1Color = tarjeta2Texto1Color,
                    text2Color = tarjeta2Texto2Color
                )
            }
        }
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