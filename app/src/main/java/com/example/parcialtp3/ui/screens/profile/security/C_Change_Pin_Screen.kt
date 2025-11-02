package com.example.parcialtp3.ui.screens.profile.security

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.LightGreen

@Composable
fun C_Change_Pin_Success_Screen(
    message: String = "Pin Has Been\nChanged Successfully",
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CaribbeanGreen)
            .padding(WindowInsets.systemBars.asPaddingValues()),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(R.drawable.icon_check_progress1),
                contentDescription = null,
                modifier = Modifier.size(140.dp),
                tint = Color.Unspecified
            )
            Spacer(Modifier.height(24.dp))
            Text(
                text = message,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = LightGreen
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Success")
@Composable
private fun PreviewSuccess() {
    C_Change_Pin_Success_Screen()
}
