package com.example.parcialtp3.ui.components



import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.FenceGreen
import com.example.parcialtp3.ui.LightBlue
import com.example.parcialtp3.ui.VividBlue
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.poppinsFamily

@Composable
fun <T> CategoryPanel(
    month1Name: String,
    month1Expenses: List<T>,
    month2Name: String,
    month2Expenses: List<T>,
    title: (T) -> String,
    time: (T) -> String,
    amount: (T) -> String,
    @DrawableRes iconResId: Int,
    onAddExpense: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = month1Name,
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    color = Void
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Surface(
                modifier = Modifier.size(36.dp),
                shape = CircleShape,
                color = CaribbeanGreen,
                shadowElevation = 0.dp
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        painter = painterResource(id = R.drawable.vector_calendar),
                        contentDescription = "Calendar",
                        tint = FenceGreen,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(bottom = 12.dp)
        ) {
            itemsIndexed(month1Expenses) { index, expense ->
                CategoryExpenseRow(
                    expense = expense,
                    title = title,
                    time = time,
                    amount = amount,
                    iconResId = iconResId,
                    iconBackground = if (index % 2 == 0) LightBlue else VividBlue
                )
            }

            item {
                Text(
                    text = month2Name,
                    modifier = Modifier.padding(top = 12.dp, bottom = 8.dp),
                    style = TextStyle(
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        color = Void
                    )
                )
            }

            itemsIndexed(month2Expenses) { index, expense ->
                CategoryExpenseRow(
                    expense = expense,
                    title = title,
                    time = time,
                    amount = amount,
                    iconResId = iconResId,
                    iconBackground = if (index % 2 == 0) LightBlue else VividBlue
                )
            }
        }

        PrimaryButton(
            text = "Add Expenses",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .wrapContentWidth(Alignment.CenterHorizontally),
            onClick = onAddExpense
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}