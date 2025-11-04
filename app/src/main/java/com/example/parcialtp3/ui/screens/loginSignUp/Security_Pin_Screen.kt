package com.example.parcialtp3.ui.screens.loginSignUp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.FacebookGoogle
import com.example.parcialtp3.ui.components.OtpCircleInput
import com.example.parcialtp3.ui.components.RoundedButton
import com.example.parcialtp3.ui.components.RoundedPassInput
import com.example.parcialtp3.ui.components.TitleText

@Composable
fun SecurityPinScreen(
    navController: NavHostController
) {
    BackgroundScaffold(
        headerHeight = 187.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = { Title() },
        panelContent = { Body(navController) }
    )
}

@Composable
private fun Title() {
    TitleText("Security Pin", fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 18.dp))
}
@Composable
private fun Body(
    navController: NavHostController
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp)
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        TitleText(
            "Enter Security Pin",
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 18.dp), // 2. Ya no necesita .align()
            fontSize = 20.sp
        )
        Spacer(Modifier.height(50.dp))

        OtpCircleInput(
            circleSpacing = 18.dp,
            onComplete = {}
        )
        Spacer(Modifier.height(50.dp))

        RoundedButton(
            "Accept",
            onClick = {},
            width = 169.dp,
            height = 32.dp,
            navController = navController,
            route = "NewPasswordScreen"
        )
        Spacer(Modifier.height(10.dp))

        RoundedButton(
            "Send Again",
            backgroundColor = LightGreen,
            onClick = {},
            width = 169.dp,
            height = 32.dp,
            navController = navController
        )
        Spacer(Modifier.height(200.dp))
        FacebookGoogle(navController)
    }
}
