package com.example.parcialtp3.ui.screens.categories.saving

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.example.parcialtp3.ui.components.MessageBox
import com.example.parcialtp3.ui.components.PrimaryButton
import com.example.parcialtp3.ui.components.RoundedInputRow

@Composable
fun Wedding_Expense_Screen(
    navController: NavHostController
) {
    BackgroundScaffold(
        headerHeight = 180.dp,
        headerContent = {
            HeaderBar(
                title = "Add Savings",
                navController = navController,
                onBackClick = { navController.popBackStack() }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                RoundedInputRow(
                    label = "Date",
                    value = "November 15, 2024",
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
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                RoundedInputRow(
                    label = "Category",
                    value = "Wedding",
                    valueColor = Cyprus,
                    trailing = {
                        Icon(
                            painter = painterResource(id = R.drawable.vector_down),
                            contentDescription = "down",
                            tint = Color.Unspecified
                        )
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                RoundedInputRow(
                    label = "Amount",
                    value = "$87.32",
                    valueColor = Void
                )
                Spacer(modifier = Modifier.height(16.dp))
                RoundedInputRow(
                    label = "Expense Title",
                    value = "Wedding Deposit",
                    valueColor = Void
                )
                Spacer(modifier = Modifier.height(16.dp))
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
                    onClick = { }
                )
            }
        }
    }
}