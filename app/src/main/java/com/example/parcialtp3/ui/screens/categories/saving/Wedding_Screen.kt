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

data class WeddingDeposit(
    val title: String,
    val time: String,
    val amount: String,
    @DrawableRes val iconRes: Int
)

@Composable
fun WeddingScreen(
    navController: NavHostController
) {
    val weddingIcon = R.drawable.vector_wedding


    val novemberDeposits = listOf(
        WeddingDeposit("Wedding Deposit", "18:46 - November 15", "$87.32", weddingIcon)
    )


    val septemberDeposits = listOf(
        WeddingDeposit("Wedding Deposit", "21:45 - September 30", "$22.99", weddingIcon),
        WeddingDeposit("Wedding Deposit", "12:25 - September 15", "$185.94", weddingIcon)
    )



    val monthSections = mapOf(
        "November" to novemberDeposits,
        "September" to septemberDeposits
    )

    BackgroundScaffold(
        headerHeight = 120.dp,
        headerContent = {
            HeaderBar(
                title = "Wedding",
                navController = navController,
                onBackClick = { navController.popBackStack() }
            )
        },
        panelContent = {
            Column(Modifier.fillMaxWidth()) {
                Spacer(Modifier.height(16.dp))
                SavingsTargetSummaryGeneric(
                    title = "Wedding",
                    iconRes = weddingIcon,
                    goalAmount = "$34,700",
                    savedAmount = "$296.25",
                    progressPercent = 0.10f,
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
                         navController?.navigate("wedding/addSavings")
                    }
                )
            }
        }
    )
}