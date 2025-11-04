package com.example.parcialtp3.ui.screens.categories.saving

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.SavingsDepositPanel
import com.example.parcialtp3.ui.components.SavingsTargetSummaryGeneric

data class NewHouseDeposit(
    val title: String,
    val time: String,
    val amount: String,
    @DrawableRes val iconRes: Int
)

@Composable
fun NewHouseScreen(
    navController: NavHostController
) {
    val houseIcon = R.drawable.vector_newhouse

    val aprilDeposits = listOf(
        NewHouseDeposit("House Deposit", "19:56 – April 5", "$477.77", houseIcon)
    )

    val januaryDeposits = listOf(
        NewHouseDeposit("House Deposit", "20:25 – January 16", "$102.67", houseIcon),
        NewHouseDeposit("House Deposit", "15:56 – January 02", "$45.04", houseIcon)
    )

    val monthSections = linkedMapOf(
        "April" to aprilDeposits,
        "January" to januaryDeposits
    )

    BackgroundScaffold(
        headerHeight = 120.dp,
        headerContent = {
            HeaderBar(
                title = "New House",
                navController = navController
            )
        },
        panelContent = {
            Column(Modifier.fillMaxWidth()) {
                Spacer(Modifier.height(16.dp))
                SavingsTargetSummaryGeneric(
                    title = "New House",
                    iconRes = houseIcon,
                    goalAmount = "$569,200",
                    savedAmount = "$625.48",
                    progressPercent = 0.30f,
                    progressColor = CaribbeanGreen,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                SavingsDepositPanel(
                    monthSections = monthSections,
                    title = { it.title },
                    time = { it.time },
                    amount = { it.amount },
                    iconRes = { it.iconRes },
                    onAddSavingsClick = {
                         navController?.navigate("newHouse/addSavings")
                    }
                )
            }
        }
    )
}