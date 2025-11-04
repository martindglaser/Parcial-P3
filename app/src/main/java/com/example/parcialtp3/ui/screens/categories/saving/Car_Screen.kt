

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

data class CarDeposit(
    val title: String,
    val time: String,
    val amount: String,
    @DrawableRes val iconRes: Int
)

@Composable
fun CarScreen(
    navController: NavHostController
) {
    val carIcon = R.drawable.vector_car

    val aprilDeposits = listOf(
        CarDeposit("Car Deposit", "14:16 - July 5", "$387.32", carIcon),
        CarDeposit("Car Deposit", "21:45 - May 30", "$122,99", carIcon),
        CarDeposit("House deposit", "14:25 - May 05", "$85.94", carIcon)
    )

    val monthSections = mapOf(
        "April" to aprilDeposits
    )

    BackgroundScaffold(
        headerHeight = 120.dp,
        headerContent = {
            HeaderBar(
                title = "Car",
                navController = navController
            )
        },
        panelContent = {
            Column(Modifier.fillMaxWidth()) {
                Spacer(Modifier.height(16.dp))
                SavingsTargetSummaryGeneric(
                    title = "Car",
                    iconRes = carIcon,
                    goalAmount = "$14,390",
                    savedAmount = "$596.25",
                    progressPercent = 0.15f,
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
                        navController?.navigate("car/addSavings")
                    }
                )
            }
        }
    )
}