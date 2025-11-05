package com.example.parcialtp3.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.ui.ThemeAwareColors

@Composable
fun BottomNavIcon(
    iconResId: Int,
    contentDescription: String
) {
    val themeColors = ThemeAwareColors.getColors()
    Icon(
        painter = painterResource(id = iconResId),
        contentDescription = contentDescription,
        modifier = Modifier.size(26.dp),
        tint = themeColors.iconColorBottomNavBar
    )
}
