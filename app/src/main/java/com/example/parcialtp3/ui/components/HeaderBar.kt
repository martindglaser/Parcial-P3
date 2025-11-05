package com.example.parcialtp3.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.poppinsFamily

@Composable
fun HeaderBar(
    title: String,
    navController: NavHostController,
    onBackClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Flecha para volver
        Image(
            painter = painterResource(id = R.drawable.bring_back),
            contentDescription = "Back",
            modifier = Modifier
                .size(24.dp)
                .clickable { onBackClick?.invoke() },
            contentScale = ContentScale.Fit
        )

        // Título centrado
        TitleText(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )

        // Botón funcional de notificaciones (reutiliza el composable NotificationFAB)
        NotificationFAB(navController = navController)
    }
}



