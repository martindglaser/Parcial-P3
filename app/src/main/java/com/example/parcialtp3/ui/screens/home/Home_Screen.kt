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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.FenceGreen
import com.example.parcialtp3.ui.OceanBlue
import com.example.parcialtp3.ui.Void
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
        HomeTransaction(R.drawable.vector_salary, "Salary", "18:27 – April 30", "Monthly", "$4.000,00"),
        HomeTransaction(R.drawable.vector_groceries, "Groceries", "17:00 – April 24", "Pantry", "-$100,00"),
        HomeTransaction(R.drawable.vector_rent, "Rent", "8:30 – April 15", "Rent", "-$674,40")
    )

    var selectedFilter by remember { mutableStateOf("Monthly") }

    Box(modifier = Modifier.fillMaxSize()) {

        BackgroundScaffold(
            headerHeight = 330.dp,
            headerColor = CaribbeanGreen,
            panelColor = Honeydew,
            headerContent = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    HeaderBar(title = "Hi, Welcome Back", navController = navController)
                    Spacer(Modifier.height(2.dp))
                    Text("Good Morning", color = Void, fontFamily = poppinsFamily)
                    Spacer(Modifier.height(2.dp))
                    FinanceSummaryBlock(
                        modifier = Modifier.clickable {
                            navController.navigate("account_balance")
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            },
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
                                Image(
                                    painter = painterResource(id = R.drawable.vector_gift),
                                    contentDescription = "Savings Icon",
                                    modifier = Modifier.size(40.dp)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Savings\nOn Goals", color = Void, fontFamily = poppinsFamily)
                            }
                            Box(
                                modifier = Modifier
                                    .width(1.5.dp)
                                    .height(70.dp)
                                    .background(Void.copy(alpha = 0.8f))
                            )
                            Column(
                                modifier = Modifier
                                    .weight(2f)
                                    .padding(start = 10.dp),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = painterResource(id = R.drawable.vector_salary),
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
                                        .background(Void.copy(alpha = 0.5f))
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

                    Spacer(modifier = Modifier.height(6.dp))

                    // ───── Filtros ─────
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        listOf("Daily", "Weekly", "Monthly").forEach { label ->
                            val isSelected = selectedFilter == label
                            Surface(
                                color = if (isSelected)
                                    CaribbeanGreen
                                else Color(0xFF013B36).copy(alpha = 0.4f),
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(horizontal = 4.dp)
                                    .height(36.dp)
                                    .clickable { selectedFilter = label }
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = label,
                                        color = if (isSelected) Honeydew else Color(0xFFB6E0DC),
                                        fontFamily = poppinsFamily
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    TransactionsMonthSection(viewModel = viewModel)
                }
            }
        )

        // --- Bottom Navigation Bar ---
        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            color = Color(0xFF013B36),
            shadowElevation = 12.dp
        ) {
            BottomNavBar(navController = navController, current = "HomeScreen")
        }
    }
}