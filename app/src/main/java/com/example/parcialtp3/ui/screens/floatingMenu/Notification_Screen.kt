package com.example.parcialtp3.ui.screens.notifications

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.*

data class NotificationItem(
    val iconRes: Int,
    val title: String,
    val message: String,
    val date: String,
    val category: String? = null,
    val amount: String? = null,
    val section: String
)

@Composable
fun NotificationScreen(navController: NavHostController) {
    val notifications = listOf(
        NotificationItem(
            R.drawable.ic_campana,
            "Reminder!",
            "Set up your automatic savings to meet your savings goal…",
            "17:00 – April 24",
            section = "Today"
        ),
        NotificationItem(
            R.drawable.ic_estrella,
            "New Update",
            "Set up your automatic savings to meet your savings goal…",
            "17:00 – April 24",
            section = "Today"
        ),
        NotificationItem(
            R.drawable.ic_plata,
            "Transactions",
            "A new transaction has been registered",
            "17:00 – April 24",
            category = "Groceries | Pantry",
            amount = "-$100,00",
            section = "Yesterday"
        ),
        NotificationItem(
            R.drawable.ic_campana,
            "Reminder!",
            "Set up your automatic savings to meet your savings goal…",
            "17:00 – April 24",
            section = "Yesterday"
        ),
        NotificationItem(
            R.drawable.ic_flecha_mirando_abajo,
            "Expense Record",
            "We recommend that you be more attentive to your finances.",
            "17:00 – April 24",
            section = "This Weekend"
        ),
        NotificationItem(
            R.drawable.ic_plata,
            "Transactions",
            "A new transaction has been registered",
            "17:00 – April 24",
            category = "Food | Dinner",
            amount = "-$70,40",
            section = "This Weekend"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CaribbeanGreen)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 28.dp, horizontal = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Notification",
                color = Void,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            // Flecha atrás
            Image(
                painter = painterResource(id = R.drawable.bring_back),
                contentDescription = "Back",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(26.dp)
                    .clickable { navController.popBackStack() }
            )

            // Campana
            Image(
                painter = painterResource(id = R.drawable.ic_campana),
                contentDescription = "Bell",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(26.dp)
            )
        }

        // Contenedor redondeado inferior (contenido principal)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(Honeydew)
                .padding(horizontal = 16.dp, vertical = 20.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val grouped = notifications.groupBy { it.section }
                grouped.forEach { (section, items) ->
                    item {
                        Text(
                            text = section,
                            color = Void,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 13.sp,
                            modifier = Modifier.padding(vertical = 6.dp)
                        )
                    }

                    itemsIndexed(items) { index, notif ->
                        NotificationCard(notif)
                        // Divider entre notificaciones del mismo grupo
                        if (index != items.lastIndex) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(CaribbeanGreen)
                            )
                        }
                    }

                    // Divider adicional entre grupos (Today → Yesterday → This Weekend)
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(CaribbeanGreen)
                                .padding(vertical = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NotificationCard(item: NotificationItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Row(verticalAlignment = Alignment.Top) {
            // Icono (mantiene su color original)
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(LightGreen),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = item.iconRes),
                    contentDescription = item.title,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.title,
                    color = Void,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp
                )

                Text(
                    text = item.message,
                    color = Void,
                    fontFamily = poppinsFamily,
                    fontSize = 13.sp
                )

                // Subtítulo en azul para transacciones
                if (item.category != null && item.amount != null) {
                    Text(
                        text = "${item.category} | ${item.amount}",
                        color = OceanBlue,
                        fontFamily = poppinsFamily,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        // Fecha en la parte inferior derecha
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(
                text = item.date,
                color = OceanBlue,
                fontFamily = poppinsFamily,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 4.dp, end = 4.dp)
            )
        }
    }
}