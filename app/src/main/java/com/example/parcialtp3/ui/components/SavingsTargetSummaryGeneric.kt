package com.example.parcialtp3.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.FenceGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.LightBlue
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.poppinsFamily

@Composable
fun SavingsTargetSummaryGeneric(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes iconRes: Int,
    goalAmount: String,
    savedAmount: String,
    progressPercent: Float,
    progressColor: Color = CaribbeanGreen
) {
    val darkTeal = Color(0xFF031314)
    val totalWidth = 330.dp
    val height = 27.dp
    val pct = progressPercent.coerceIn(0f, 1f)
    val darkWidth = totalWidth * pct

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(26.dp))
            .background(Honeydew)
            .padding(vertical = 16.dp, horizontal = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.vector_balance),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Goal",
                        style = TextStyle(
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = FenceGreen
                        )
                    )
                }
                Text(
                    text = goalAmount,
                    style = TextStyle(
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = FenceGreen
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.vector_expense),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Amount Saved",
                        style = TextStyle(
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = FenceGreen
                        )
                    )
                }
                Text(
                    text = savedAmount,
                    style = TextStyle(
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = CaribbeanGreen
                    )
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(LightBlue)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.vector_circle),
                    contentDescription = title,
                    modifier = Modifier.size(100.dp)
                )
                Image(
                    painter = painterResource(id = iconRes),
                    contentDescription = title,
                    modifier = Modifier.size(50.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .width(totalWidth)
                .height(height)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(50))
                    .background(progressColor)
            )
            if (pct > 0f) {
                Box(
                    modifier = Modifier
                        .width(darkWidth)
                        .height(height)
                        .clip(RoundedCornerShape(topStart = 50.dp, bottomStart = 50.dp))
                        .background(darkTeal)
                        .align(Alignment.CenterStart)
                )
            }
            if (pct in 0f..1f && pct != 1f) {
                Box(
                    modifier = Modifier
                        .size(height)
                        .align(Alignment.CenterStart)
                        .offset(x = darkWidth - height / 2)
                        .clip(CircleShape)
                        .background(progressColor)
                )
            }
            Row(
                modifier = Modifier
                    .matchParentSize()
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${(pct * 100).toInt()}%",
                    style = TextStyle(
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = goalAmount,
                    style = TextStyle(
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = LightGreen
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "30% Of Your Expenses, Looks Good.",
            modifier = Modifier.fillMaxWidth(),
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