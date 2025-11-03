package com.example.parcialtp3.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.*
import com.example.parcialtp3.ui.poppinsFamily


data class MonthlyExpenseGroup<T>(
    val month: String,
    val expenses: List<T>
)

@Composable
fun <T> CategoryPanel(
    monthlyExpenses: List<MonthlyExpenseGroup<T>>,
    expenseData: (T) -> Triple<String, String, String>,
    @DrawableRes iconResId: Int,
    onAddExpense: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {

            var globalExpenseIndex = 0

            monthlyExpenses.forEachIndexed { monthIndex, monthlyData ->

                item {
                    CategoryPanelMonthHeader(
                        month = monthlyData.month,
                        showCalendar = monthIndex == 0
                    )
                }

                items(monthlyData.expenses) { expenseItem ->

                    val (title, time, amount) = expenseData(expenseItem)

                    CategoryExpenseRow(

                        title = title,
                        time = time,
                        amount = amount,
                        iconResId = iconResId,
                        iconBackground = if (globalExpenseIndex % 2 == 0) VividBlue else LightBlue
                    )
                    globalExpenseIndex++
                }
            }

            item {
                Spacer(modifier = Modifier.height(6.dp))
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 18.dp),
            contentAlignment = Alignment.Center
        ) {
            PrimaryButton(
                text = "Add Expenses",
                onClick = onAddExpense
            )
        }
    }
}

@Composable
private fun CategoryPanelMonthHeader(
    month: String,
    showCalendar: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = month,
            fontFamily = poppinsFamily,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Void
        )
        Spacer(modifier = Modifier.weight(1f))
        if (showCalendar) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(CaribbeanGreen)
                    .padding(7.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.vector_calendar),
                    contentDescription = null,
                    modifier = Modifier
                        .height(18.dp)
                        .width(18.dp)
                )
            }
        }
    }
}


@Composable
fun CategoryExpenseRow(
    title: String,
    time: String,
    amount: String,
    @DrawableRes iconResId: Int,
    iconBackground: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(iconBackground),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = title,
                tint = Color.White,
                modifier = Modifier.size(22.dp)
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                fontFamily = poppinsFamily,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Void
            )
            Text(
                text = time,
                fontFamily = poppinsFamily,
                fontSize = 12.sp,
                color = Color(0xFF1064C8)
            )
        }
        Text(
            text = amount,
            fontFamily = poppinsFamily,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = OceanBlue
        )
    }
}