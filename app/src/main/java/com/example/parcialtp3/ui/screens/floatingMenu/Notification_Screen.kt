package com.example.parcialtp3.ui.screens.notifications

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.poppinsFamily

data class NotificationItem(
    val icon: Int,
    val title: String,
    val message: String,
    val time: String
)

@Composable
fun NotificationScreen(navController: NavHostController) {
    val notifications = listOf(
        NotificationItem(R.drawable.ic_notification, "Reminder!", "Set up your automatic savings...", "17:00 - April 24"),
        NotificationItem(R.drawable.ic_notification, "New Update", "A new transaction has been registered.", "17:00 - April 24"),
        NotificationItem(R.drawable.ic_notification, "Transactions", "Groceries | Pantry | -$100.00", "17:00 - April 24")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF002B28))
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Notification",
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFamily
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(notifications) { notif ->
                NotificationCard(notif)
            }
        }
    }
}

@Composable
fun NotificationCard(item: NotificationItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            modifier = Modifier.size(42.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(item.title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(item.message, color = Color.LightGray, fontSize = 13.sp)
        }
        Text(item.time, color = Color.Gray, fontSize = 12.sp)
    }
}
