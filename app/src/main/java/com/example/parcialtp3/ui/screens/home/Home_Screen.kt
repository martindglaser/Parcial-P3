package com.example.parcialtp3.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.*
import com.example.parcialtp3.ui.components.*
import com.example.parcialtp3.ui.poppinsFamily
import com.example.parcialtp3.ui.viewmodels.TransactionsViewModel

data class HomeTransaction(
    val iconRes: Int,
    val title: String,
    val subtitle: String,
    val category: String,
    val amount: String
)

@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel: TransactionsViewModel = viewModel()
    val transactions = listOf(
        HomeTransaction(R.drawable.icon_salary, "Salary", "18:27 – April 30", "Monthly", "$4.000,00"),
        HomeTransaction(R.drawable.icon_groceries, "Groceries", "17:00 – April 24", "Pantry", "-$100,00"),
        HomeTransaction(R.drawable.icon_rent, "Rent", "8:30 – April 15", "Rent", "-$674,40")
    )

    var selectedFilter by remember { mutableStateOf("Monthly") }

    Box(modifier = Modifier.fillMaxSize()) {

        BackgroundScaffold(
            current = "HomeScreen",
            navController = navController,
            headerHeight = 320.dp,
            headerContent = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Spacer(modifier = Modifier.height(1.dp))

                    // Fila superior: título y botón de notificaciones
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            // Título principal
                            Text(
                                text = "Hi, Welcome Back.",
                                color = Void,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                                modifier = Modifier
                                    .width(278.dp)
                                    .height(22.dp)
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            // Subtítulo
                            Text(
                                text = "Good Morning",
                                color = Void,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 13.sp,
                                modifier = Modifier
                                    .width(169.dp)
                                    .height(13.dp)
                            )
                        }

                        // Icono de notificaciones clickeable
                        Image(
                            painter = painterResource(id = R.drawable.icon_notification),
                            contentDescription = "Notifications",
                            modifier = Modifier
                                .size(32.dp)
                                .clickable {
                                    navController.navigate("notifications")
                                }
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Bloque financiero
                    FinanceSummaryBlock(
                        modifier = Modifier.clickable {
                            navController.navigate("account_balance")
                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

            ,
            panelContent = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp)
                ) {
                    // ───── Tarjeta resumen semanal ─────
                    Surface(
                        color = CaribbeanGreen,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.weight(1f)
                            ) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.size(90.dp)
                                ) {
                                    // Círculo dividido mitad blanca, mitad azul
                                    Box(
                                        modifier = Modifier
                                            .matchParentSize()
                                            .clip(CircleShape)
                                    ) {
                                        Row(Modifier.matchParentSize()) {
                                            Box(
                                                Modifier
                                                    .weight(1f)
                                                    .fillMaxHeight()
                                                    .background(Honeydew)
                                            )
                                            Box(
                                                Modifier
                                                    .weight(1f)
                                                    .fillMaxHeight()
                                                    .background(OceanBlue)
                                            )
                                        }
                                    }

                                    // Ícono centrado
                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier
                                            .size(78.dp)
                                            .clip(CircleShape)
                                            .background(CaribbeanGreen)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.vector_car),
                                            contentDescription = "Savings Icon",
                                            modifier = Modifier.size(40.dp)
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Savings\nOn Goals", color = Void, fontFamily = poppinsFamily)
                            }

                            Box(
                                modifier = Modifier
                                    .width(1.5.dp)
                                    .height(70.dp)
                                    .background(Honeydew.copy(alpha = 0.8f))
                            )

                            Column(
                                modifier = Modifier
                                    .weight(2f)
                                    .padding(start = 10.dp),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_salary),
                                        contentDescription = "Revenue Icon",
                                        modifier = Modifier.size(22.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Column {
                                        Text("Revenue Last Week", color = Void, fontFamily = poppinsFamily)
                                        Text("$4.000,00", color = FenceGreen, fontFamily = poppinsFamily)
                                    }
                                }

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Honeydew.copy(alpha = 0.5f))
                                )

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = painterResource(id = R.drawable.vector_food),
                                        contentDescription = "Food Icon",
                                        modifier = Modifier.size(22.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Column {
                                        Text("Food Last Week", color = Void, fontFamily = poppinsFamily)
                                        Text("-$100,00", color = OceanBlue, fontFamily = poppinsFamily)
                                    }
                                }
                            }
                        }
                    }


                    Spacer(modifier = Modifier.height(10.dp))

                    // ───── Filtros ─────
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                            .background(
                                color = LightGreen,
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(24.dp)
                            )
                            .padding(horizontal = 6.dp, vertical = 6.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            listOf("Daily", "Weekly", "Monthly").forEach { label ->
                                val isSelected = selectedFilter == label
                                Surface(
                                    color = if (isSelected) CaribbeanGreen else Color.Transparent,
                                    shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp),
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(46.dp)
                                        .clickable { selectedFilter = label }
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text(
                                            text = label,
                                            color = Void,
                                            fontFamily = poppinsFamily,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                            fontSize = 14.sp
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    // ───── Transacciones ────
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 4.dp),
                        contentPadding = PaddingValues(bottom = 100.dp)
                    ) {
                        items(transactions) { t ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Ícono circular perfectamente centrado y proporcionado
                                Box(
                                    modifier = Modifier
                                        .size(44.dp)
                                        .clip(CircleShape)
                                        .background(
                                            if (t.amount.startsWith("-")) LightBlue.copy(alpha = 0.3f)
                                            else LightGreen
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = t.iconRes),
                                        contentDescription = t.title,
                                        modifier = Modifier.size(22.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.width(14.dp))

                                // Columna izquierda (título y subtítulo)
                                Column(
                                    modifier = Modifier.weight(1.3f),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = t.title,
                                        color = Void,
                                        fontFamily = poppinsFamily,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 15.sp
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = t.subtitle,
                                        color = OceanBlue,
                                        fontFamily = poppinsFamily,
                                        fontSize = 12.sp
                                    )
                                }

                                // Línea vertical centrada
                                Box(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .height(36.dp)
                                        .background(CaribbeanGreen.copy(alpha = 0.5f))
                                )

                                // Categoría centrada
                                Box(
                                    modifier = Modifier
                                        .weight(0.8f)
                                        .fillMaxHeight(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = t.category,
                                        color = FenceGreen,
                                        fontFamily = poppinsFamily,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }

                                // Línea vertical centrada
                                Box(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .height(36.dp)
                                        .background(CaribbeanGreen.copy(alpha = 0.5f))
                                )

                                // Monto centrado
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxHeight(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = t.amount,
                                        color = if (t.amount.startsWith("-")) OceanBlue else FenceGreen,
                                        fontFamily = poppinsFamily,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 15.sp
                                    )
                                }
                            }

                            // Divider sutil entre transacciones
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(Honeydew.copy(alpha = 0.6f))
                            )
                        }
                    }


                }
            }
        )
    }
}