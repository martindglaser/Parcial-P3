package com.example.parcialtp3.ui.screens.accountBalance

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
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
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.FenceGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.LightBlue
import com.example.parcialtp3.ui.OceanBlue
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.FinanceSummaryBlock
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.poppinsFamily

data class AccountTransaction(
    val iconRes: Int,
    val title: String,
    val subtitle: String,
    val category: String,
    val amount: String
)

@Composable
fun AccountBalanceScreen(navController: NavHostController) {

    val transactions = listOf(
        AccountTransaction(R.drawable.vector_salary, "Salary", "18:27 – April 30", "Monthly", "+$4,000.00"),
        AccountTransaction(R.drawable.vector_groceries, "Groceries", "17:00 – April 24", "Pantry", "-$100.00"),
        AccountTransaction(R.drawable.vector_rent, "Rent", "8:30 – April 15", "Rent", "-$674.40"),
        AccountTransaction(R.drawable.vector_transport, "Transport", "9:30 – April 08", "Fuel", "-$4.13")
    )

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundScaffold(
            navController = navController,
            current = "account_balance",
            headerHeight = 460.dp,
            headerContent = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    HeaderBar(
                        title = "Account Balance",
                        navController = navController,
                        onBackClick = { navController.navigate("HomeScreen") }
                    )

                    Spacer(modifier = Modifier.height(14.dp))
                    FinanceSummaryBlock()
                    Spacer(modifier = Modifier.height(18.dp))

                    // --- Income y Expense Cards ---
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Surface(
                            color = Honeydew,
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(110.dp)
                                .clickable { navController.navigate("Income_Screen") }
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(14.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.group_395),
                                    contentDescription = "Income",
                                    modifier = Modifier.size(26.dp)
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Income",
                                    color = Void,
                                    fontFamily = poppinsFamily,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "$4,000.00",
                                    color = Void,
                                    fontFamily = poppinsFamily,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Surface(
                            color = Honeydew,
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(110.dp)
                                .clickable { navController.navigate("Expense_Screen") }
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(14.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.group_396),
                                    contentDescription = "Expense",
                                    modifier = Modifier.size(26.dp)
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Expense",
                                    color = OceanBlue,
                                    fontFamily = poppinsFamily,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "$1,187.40",
                                    color = OceanBlue,
                                    fontFamily = poppinsFamily,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                }
            },
            panelContent = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Transactions",
                            color = Void,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp
                        )

                        Text(
                            text = "See all",
                            color = FenceGreen,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.clickable {
                                navController.navigate("transactions")
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // --- Transacciones ---
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(bottom = 120.dp)
                    ) {
                        itemsIndexed(transactions) { index, t ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Icono circular celeste
                                Box(
                                    modifier = Modifier
                                        .size(44.dp)
                                        .clip(CircleShape)
                                        .background(LightBlue.copy(alpha = 0.3f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = t.iconRes),
                                        contentDescription = t.title,
                                        modifier = Modifier.size(22.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.width(12.dp))

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

                                // Línea vertical verde
                                Box(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .height(36.dp)
                                        .background(CaribbeanGreen)
                                )

                                // Categoría
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

                                // Línea vertical verde
                                Box(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .height(36.dp)
                                        .background(CaribbeanGreen)
                                )

                                // Monto
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxHeight(),
                                    contentAlignment = Alignment.CenterEnd
                                ) {
                                    Text(
                                        text = t.amount,
                                        color = if (t.amount.startsWith("-")) OceanBlue else FenceGreen,
                                        fontFamily = poppinsFamily,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp
                                    )
                                }
                            }

                            // Divider entre transacciones
                            if (index != transactions.lastIndex) {
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
            }
        )
    }
}