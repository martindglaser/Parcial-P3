package com.example.parcialtp3.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew

@Composable
fun SuccessScreen(
    message: String,
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = CaribbeanGreen,
    textColor: Color = Honeydew,
    iconTint: Color = Color.Unspecified,
    iconSizeDp: Int = 140,
    spacingDp: Int = 24,
    textSizeSp: Int = 18,
    textWeight: FontWeight = FontWeight.Bold
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(WindowInsets.systemBars.asPaddingValues()),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = null,
                modifier = Modifier.size(iconSizeDp.dp),
                tint = iconTint
            )
            Spacer(Modifier.height(spacingDp.dp))
            Text(
                text = message,
                textAlign = TextAlign.Center,
                color = textColor,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = textSizeSp.sp,
                    fontWeight = textWeight
                )
            )
        }
    }
}
