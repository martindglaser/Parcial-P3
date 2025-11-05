package com.example.parcialtp3.ui.screens.loginSignUp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.RoundedButton
import com.example.parcialtp3.ui.components.RoundedPassInput
import com.example.parcialtp3.ui.components.TitleText

@Composable
fun NewPasswordScreen(
    navController: NavHostController
) {
    BackgroundScaffold(
        displayBottomNavBar = false,
        navController = navController,
        headerHeight = 187.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = { Title() },
        panelContent = { Body(navController) }
    )
}

@Composable
private fun Title() {
    TitleText("New password", fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 18.dp))
}
@Composable
private fun Body(
    navController: NavHostController
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp)
            .padding(top = 50.dp)
        ){
        RoundedPassInput(
            label = "New Password",
            labelPaddingLeft = 0.dp,
            passPaddingLeft = 20.dp
        )
        Spacer(Modifier.height(40.dp))
        RoundedPassInput(
            label = "Confirm New Password",
            labelPaddingLeft = 0.dp,
            passPaddingLeft = 20.dp
        )
        Spacer(Modifier.height(180.dp))
        RoundedButton(
            text = "Change Password",
            width = 357.dp,
            height = 45.dp,
            backgroundColor = CaribbeanGreen,
            onClick = {},
            navController = navController,
            route = "WelcomeScreen"
        )

    }
}