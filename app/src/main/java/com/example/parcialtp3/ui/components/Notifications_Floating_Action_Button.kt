package com.example.parcialtp3.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen

@Composable
fun NotificationFAB(navController: NavHostController) {
    FloatingActionButton(
        onClick = { navController.navigate("notifications") },
        containerColor = CaribbeanGreen,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier.size(60.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_notification),
            contentDescription = "Notifications",
            modifier = Modifier.size(28.dp)
        )
    }
}
