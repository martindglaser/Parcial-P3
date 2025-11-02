package com.example.parcialtp3.ui.screens.categories.gifts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height
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
fun Gifts_Add_Expenses_Screen(
    navController: NavController? = null
) {
    BackgroundScaffold(
        headerHeight = 180.dp,
        headerColor = CaribbeanGreen,
        panelColor = Honeydew,
        headerContent = {
            HeaderBar(
                title = "Add Expenses",
                onBackClick = { navController?.popBackStack() },
                onNotificationClick = { }
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
                    value = "April 28, 2024",
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
                androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(16.dp))
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
                androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(16.dp))
                RoundedInputRow(
                    label = "Amount",
                    value = "$30,00",
                    valueColor = Void
                )
                androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(16.dp))
                RoundedInputRow(
                    label = "Expense Title",
                    value = "Perfume",
                    valueColor = Void
                )
                androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(16.dp))
                MessageBox(label = "Enter Message")
                androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(12.dp))
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 26.dp),
                contentAlignment = Alignment.Center
            ) {
                PrimaryButton(
                    text = "Save",
                    onClick = { navController?.popBackStack() }
                )
            }
        }
    }
}

