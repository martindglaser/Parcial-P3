package com.example.parcialtp3.ui.screens.categories.food

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Cyprus
import com.example.parcialtp3.ui.FenceGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.PrimaryButton
// NUEVOS IMPORTS
import com.example.parcialtp3.ui.components.MessageBox
import com.example.parcialtp3.ui.components.RoundedInputRow

@Composable
fun FoodAddExpenseScreen(
    navController: NavHostController
) {
    BackgroundScaffold(
        headerHeight = 180.dp,
        headerColor = CaribbeanGreen,
        panelColor = Honeydew,
        headerContent = {
            HeaderBar(
                title = "Add Expenses",
                navController = navController

            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                // --- 1) DATE ---
                RoundedInputRow(
                    label = "Date",
                    value = "April 30, 2024",
                    valueColor = Void,
                    trailing = {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(CaribbeanGreen),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.vector_calendar),
                                contentDescription = "calendar",
                                tint = FenceGreen,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))

                // --- 2) CATEGORY ---
                RoundedInputRow(
                    label = "Category",
                    value = "Select the category",
                    valueColor = Cyprus,
                    trailing = {
                        Icon(
                            painter = painterResource(id = R.drawable.vector_down),
                            contentDescription = "down",
                            tint = androidx.compose.ui.graphics.Color.Unspecified,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))

                // --- 3) AMOUNT ---
                RoundedInputRow(
                    label = "Amount",
                    value = "$26,00",
                    valueColor = Void
                )
                Spacer(modifier = Modifier.height(16.dp))

                // --- 4) EXPENSE TITLE ---
                RoundedInputRow(
                    label = "Expense Title",
                    value = "Dinner",
                    valueColor = Void
                )
                Spacer(modifier = Modifier.height(16.dp))

                // --- 5) ENTER MESSAGE ---
                MessageBox(label = "Enter Message")
                Spacer(modifier = Modifier.height(12.dp))
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 26.dp),
                contentAlignment = Alignment.Center
            ) {
                PrimaryButton(
                    text = "Save",
                    onClick = {
                        // después conectar
                    }
                )
            }
        }
    }
}