package com.example.parcialtp3.ui.screens.notifications

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.*
import com.example.parcialtp3.ui.components.BackgroundScaffold

data class NotificationItem(
    val icon: Int,
    val title: String,
    val message: String,
    val time: String
)

@Composable
fun NotificationScreen(navController: NavHostController) {
    val notifications = listOf(
        NotificationItem(
            R.drawable.ic_notification,
            "Reminder!",
            "Set up your automatic savings to reach your goals faster.",
            "17:00 - April 24"
        ),
        NotificationItem(
            R.drawable.ic_notification,
            "New Update",
            "A new transaction has been registered successfully.",
            "15:12 - April 22"
        ),
        NotificationItem(
            R.drawable.ic_notification,
            "Transactions",
            "Groceries | Pantry | -$100.00",
            "09:45 - April 20"
        )
    )

    BackgroundScaffold(
        headerHeight = 160.dp,
        headerColor = CaribbeanGreen,
        panelColor = Honeydew,
        headerContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 20.dp)
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Void
                    )
                }

                Text(
                    text = "Notifications",
                    fontSize = 22.sp,
                    color = Void,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFamily,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        },
        panelContent = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            ) {
                items(notifications) { notif ->
                    NotificationCard(item = notif)
                }
            }
        }
    )
}

@Composable
fun NotificationCard(item: NotificationItem) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Honeydew,
        shadowElevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.icon),
                contentDescription = item.title,
                modifier = Modifier.size(46.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    item.title,
                    color = Void,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    fontFamily = poppinsFamily
                )
                Text(
                    item.message,
                    color = FenceGreen,
                    fontSize = 13.sp,
                    fontFamily = poppinsFamily
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                item.time,
                color = OceanBlue,
                fontSize = 12.sp,
                fontFamily = poppinsFamily
            )
        }
    }
}
