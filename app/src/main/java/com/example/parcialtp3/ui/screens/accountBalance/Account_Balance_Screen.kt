package com.example.parcialtp3.ui.screens.accountBalance

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.*
import com.example.parcialtp3.ui.components.*
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
        AccountTransaction(R.drawable.vector_salary, "Salary", "18:27 - April 30", "Monthly", "+$4,000.00"),
        AccountTransaction(R.drawable.vector_groceries, "Groceries", "17:00 - April 24", "Pantry", "-$100.00"),
        AccountTransaction(R.drawable.vector_rent, "Rent", "8:30 - April 15", "Rent", "-$674.40"),
        AccountTransaction(R.drawable.vector_transport, "Transport", "9:30 - April 08", "Fuel", "-$4.13")
    )

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundScaffold(
            headerHeight = 480.dp,
            headerColor = CaribbeanGreen,
            panelColor = Honeydew,
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

                    Spacer(modifier = Modifier.height(12.dp))
                    FinanceSummaryBlock()
                    Spacer(modifier = Modifier.height(16.dp))

                    // --- Income y Expense ---
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        TarjetasIncomeExpense(
                            modifier = Modifier
                                .weight(1f)
                                .height(110.dp),
                            backgroundColor = LightGreen,
                            imageResId = R.drawable.group_395,
                            text1 = "Income",
                            text2 = "$4,000.00",
                            text1Color = Void,
                            text2Color = Void,
                            direccion = "Income_Screen",
                            navController = navController
                        )

                        TarjetasIncomeExpense(
                            modifier = Modifier
                                .weight(1f)
                                .height(110.dp),
                            backgroundColor = OceanBlue,
                            imageResId = R.drawable.group_396_white,
                            text1 = "Expense",
                            text2 = "$1,187.40",
                            text1Color = Honeydew,
                            text2Color = Honeydew,
                            direccion = "Expense_Screen",
                            navController = navController
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "30% Of Your Expenses, Looks Good.",
                        color = FenceGreen,
                        fontFamily = poppinsFamily,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
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
                            fontFamily = poppinsFamily
                        )
                        Text(
                            text = "See all",
                            color = FenceGreen,
                            fontFamily = poppinsFamily
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(bottom = 120.dp)
                    ) {
                        items(transactions) { t ->
                            TransactionItem(
                                iconRes = t.iconRes,
                                title = t.title,
                                subtitle = t.subtitle,
                                middleText = t.category,
                                value = t.amount,
                                valueColor = if (t.amount.startsWith("-")) OceanBlue else FenceGreen
                            )
                        }
                    }
                }
            }
        )

        // --- Bottom Navigation ---
        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            color = FenceGreen,
            shadowElevation = 12.dp
        ) {
            BottomNavBar(navController = navController, current = "transactions")
        }
    }
}
