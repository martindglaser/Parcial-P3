package com.example.parcialtp3.ui.screens.categories.saving

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
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

data class TravelDeposit(
    val title: String,
    val time: String,
    val amount: String,
    @DrawableRes val iconRes: Int
)

@Composable
fun TravelScreen(
    navController: NavHostController
) {
    val travelIcon = R.drawable.vector_plane

    val aprilDeposits = listOf(
        TravelDeposit("Travel Deposit", "19:56 - April 30", "$217.77", travelIcon),
        TravelDeposit("Travel Deposit", "17:42 - April 14", "$217.77", travelIcon),
        TravelDeposit("Travel Deposit", "12:30 - April 02", "$217.77", travelIcon)
    )

    val monthSections = linkedMapOf(
        "April" to aprilDeposits
    )

    BackgroundScaffold(
        navController = navController,
        headerHeight = 170.dp,
        headerContent = {
            HeaderBar(
                title = "Travel",
                navController = navController,
                onBackClick = { navController.popBackStack() }
            )
        },
        panelContent = {
            Column(Modifier.fillMaxWidth()) {
                Spacer(Modifier.height(16.dp))

                SavingsTargetSummaryGeneric(
                    title = "Travel",
                    iconRes = travelIcon,
                    goalAmount = "$1,962.93",
                    savedAmount = "$653.31",
                    progressPercent = 0.40f,
                    progressColor = CaribbeanGreen,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Spacer(Modifier.height(8.dp))

                SavingsDepositPanel(
                    monthSections = monthSections,
                    title = { it.title },
                    time = { it.time },
                    amount = { it.amount },
                    iconRes = { it.iconRes },
                    onAddSavingsClick = {
                        navController?.navigate("travel/addSavings")
                    }
                )
            }
        }
    )
}