package com.example.parcialtp3.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.FenceGreen
import com.example.parcialtp3.ui.poppinsFamily

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = CaribbeanGreen,
    textColor: Color = FenceGreen,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .width(169.dp)
            .height(36.dp),
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {
        Text(
            text = text,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = textColor
        )
    }
}
