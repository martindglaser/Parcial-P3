package com.example.parcialtp3.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R

@Composable
fun HeaderBar(
    title: String,
    navController: NavHostController,
    onBackClick: (() -> Unit)? = null,
    onNotificationClick: (() -> Unit)? = null // 👈 nuevo parámetro agregado
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Botón atrás
        IconButton(onClick = { onBackClick?.invoke() }) {
            Icon(
                painter = painterResource(id = R.drawable.bring_back),
                contentDescription = "Back",
                tint = Color.White
            )
        }

        // Título
        Text(
            text = title,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )

        // Botón de notificación
        IconButton(onClick = { onNotificationClick?.invoke() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "Notifications",
                tint = Color.White
            )
        }
    }
}
