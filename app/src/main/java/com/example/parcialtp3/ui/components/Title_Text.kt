package com.example.parcialtp3.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.TextUnit
import com.example.parcialtp3.R

@Composable
fun TitleText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 24.sp,
    fontWeight: FontWeight = FontWeight.Bold,
    color: Color = Color(0xFFE9F5EB), // tono verdoso similar al ejemplo
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontFamily = PoppinsFamily,
        fontWeight = fontWeight,
        textAlign = textAlign
    )
}

@Composable
fun SubtitleText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = Color(0xFFCBD6CE), // tono más claro
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontFamily = PoppinsFamily,
        fontWeight = fontWeight,
        textAlign = textAlign
    )
}
