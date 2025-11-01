package com.example.parcialtp3.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.FenceGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.poppinsFamily

@Composable
fun FinanceSummaryBlock(
    modifier: Modifier = Modifier,
    balanceLabel: String = "Total Balance",
    balanceAmount: String = "$7,783.00",
    expenseLabel: String = "Total Expense",
    expenseAmount: String = "-$1,187.40",
    progressFraction: Float = 0.30f,
    progressLabel: String = "30%",
    goalAmount: String = "$20,000.00",
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        // ─────────────────── fila superior ───────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 12.dp, bottom = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // ---- BALANCE ----
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.vector_balance),
                            contentDescription = null,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            text = balanceLabel,
                            style = TextStyle(
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                color = Void
                            )
                        )
                    }
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = balanceAmount,
                        style = TextStyle(
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Honeydew
                        )
                    )
                }
            }

            // --- DIVISOR ---
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(42.dp)
                    .background(color = Color(0xFFDFF7E2))
            )

            // ---- EXPENSE ----
            Row(
                modifier = Modifier
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(

                    modifier = Modifier.padding(start = 14.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.vector_expense),
                            contentDescription = null,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            text = expenseLabel,
                            style = TextStyle(
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                color = Void
                            )
                        )
                    }
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = expenseAmount,
                        style = TextStyle(
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 24.sp,
                            color = Color(0xFF075BFD)
                        )
                    )
                }
            }
        }

        // ─────────────────── barra ───────────────────
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(27.dp)
                .padding(horizontal = 20.dp)
        ) {
            // fondo negro
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                shape = RoundedCornerShape(50),
                color = Color(0xFF031314)
            ) {}

            // fondo blanco (parcial)
            Surface(
                modifier = Modifier
                    .fillMaxWidth(1f - progressFraction.coerceIn(0f, 1f))
                    .align(Alignment.CenterEnd),
                shape = RoundedCornerShape(50),
                color = Honeydew
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 12.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = goalAmount,
                        style = TextStyle(
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Medium,
                            fontStyle = FontStyle.Italic,
                            fontSize = 13.sp,
                            color = FenceGreen
                        )
                    )
                }
            }

            // Etiqueta de progreso (30%)
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .widthIn(min = 48.dp)
                    .align(Alignment.CenterStart),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = progressLabel,
                    style = TextStyle(
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = Honeydew
                    )
                )
            }
        }

        Spacer(Modifier.height(10.dp))

        // ─────────────────── texto de abajo ───────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.vector_check),
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = "30% Of Your Expenses, Looks Good.",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    color = FenceGreen
                )
            )
        }
    }
}