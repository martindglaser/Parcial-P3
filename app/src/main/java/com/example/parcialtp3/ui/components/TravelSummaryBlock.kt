package com.example.parcialtp3.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.poppinsFamily

@Composable
fun TravelSummaryBlock(
    modifier: Modifier = Modifier,
    progress: Float = 0.60f, // 60%
    progressLabel: String = "60%",
    savedAmount: String = "$12,000.00",
    goalAmount: String = "$20,000.00"
) {
    val progressAngle = 360 * progress
    val trackColor = Color(0xFF075BFD) // Azul
    val progressColor = Honeydew // Blanco

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // --- Círculo de Progreso ---
        Box(
            modifier = Modifier.size(90.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.size(90.dp)) {

                drawArc(
                    color = trackColor,
                    startAngle = -90f,
                    sweepAngle = 360f,
                    useCenter = false,
                    style = Stroke(width = 8.dp.toPx(), cap = StrokeCap.Round)
                )
                // Progreso
                drawArc(
                    color = progressColor,
                    startAngle = -90f,
                    sweepAngle = progressAngle,
                    useCenter = false,
                    style = Stroke(width = 8.dp.toPx(), cap = StrokeCap.Round)
                )
            }
            Text(
                text = progressLabel,
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Honeydew
                )
            )
        }

        Spacer(modifier = Modifier.width(20.dp))

        // --- Textos ---
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Saved",
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Void
                )
            )
            Text(
                text = savedAmount,
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Honeydew
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Target: $goalAmount",
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = Void
                )
            )
        }
    }
}