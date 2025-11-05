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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.poppinsFamily

@Composable
fun SavingsTargetSummary(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes iconRes: Int,
    goalAmount: String,
    savedAmount: String,
    progressPercent: Float
) {
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
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Goal",
                    style = TextStyle(
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = FenceGreen
                    )
                )
                Text(
                    text = goalAmount,
                    style = TextStyle(
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = FenceGreen
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Amount Saved",
                    style = TextStyle(
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = FenceGreen
                    )
                )
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

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(90.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.vector_circle),
                    contentDescription = "Progress Circle",
                    modifier = Modifier.size(90.dp)
                )
                Image(
                    painter = painterResource(id = iconRes),
                    contentDescription = title,
                    modifier = Modifier.size(42.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${(progressPercent * 100).toInt()}%",
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = FenceGreen
                ),
                modifier = Modifier.weight(1f)
            )
            Text(
                text = goalAmount,
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = FenceGreen
                )
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .clip(RoundedCornerShape(50))
                .background(LightGreen)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progressPercent)
                    .height(10.dp)
                    .clip(RoundedCornerShape(50))
                    .background(CaribbeanGreen)
            )
        }
    }
}