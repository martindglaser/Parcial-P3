package com.example.parcialtp3.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen

@Composable
fun NotificationFAB(navController: NavHostController) {
    Box(
        modifier = Modifier
            .size(35.dp)
            .background(Color(0xFFE9FFF6), CircleShape)
            .clickable {
                navController.navigate("notifications")
            },
        contentAlignment = Alignment.Center

    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_notification),
            contentDescription = "Notifications",
            modifier = Modifier.size(24.dp),
            contentScale = ContentScale.Fit
        )
    }
}

