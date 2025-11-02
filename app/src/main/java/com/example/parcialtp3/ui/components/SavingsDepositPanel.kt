package com.example.parcialtp3.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.FenceGreen
import com.example.parcialtp3.ui.LightBlue
import com.example.parcialtp3.ui.poppinsFamily

@Composable
fun <T> SavingsDepositPanel(
    monthSections: Map<String, List<T>>,
    title: (T) -> String,
    time: (T) -> String,
    amount: (T) -> String,
    iconRes: (T) -> Int,
    onAddSavingsClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            contentPadding = PaddingValues(bottom = 12.dp)
        ) {
            monthSections.forEach { (month, deposits) ->

                // ----- HEADER DEL MES -----
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = month,
                            style = TextStyle(
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = FenceGreen
                            )
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        // CALENDARIO
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(CaribbeanGreen),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.vector_calendar),
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                }

                // ----- ÍTEMS -----
                itemsIndexed(deposits) { index, deposit ->
                    SavingsDepositRow(
                        title = title(deposit),
                        time = time(deposit),
                        amount = amount(deposit),
                        iconRes = iconRes(deposit),
                        iconBgColor = if (index % 2 == 0)
                            LightBlue
                        else
                            LightBlue.copy(alpha = 0.85f) // segundo azul
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            PrimaryButton(
                text = "Add Savings",
                onClick = onAddSavingsClick
            )
        }
    }
}

@Composable
private fun SavingsDepositRow(
    title: String,
    time: String,
    amount: String,
    @DrawableRes iconRes: Int,
    iconBgColor: androidx.compose.ui.graphics.Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(iconBgColor),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                modifier = Modifier.size(26.dp)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = FenceGreen
                )
            )
            Text(
                text = time,
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,

                    color = CaribbeanGreen
                )
            )
        }

        Text(
            text = amount,
            style = TextStyle(
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = FenceGreen
            )
        )
    }
}
