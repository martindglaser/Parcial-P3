package com.example.parcialtp3.ui.screens.loginSignUp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.FacebookGoogle
import com.example.parcialtp3.ui.components.RoundedButton
import com.example.parcialtp3.ui.components.RoundedInputField
import com.example.parcialtp3.ui.components.SimpleText
import com.example.parcialtp3.ui.components.TitleText

@Composable
fun ForgotPasswordScreen(
    navController: NavHostController
){
    BackgroundScaffold(
        headerHeight = 187.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = { Title() },
        panelContent = { Body(navController) }
    )
}
@Composable
private fun Title() {
    TitleText("Forgot Password", color = Void, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 18.dp))
}
@Composable
private fun Body(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp)
            .padding(top = 50.dp)
    ) {
        TitleText(
            "Reset Password?",
            color = Void,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 18.dp), // Ya no necesita .align()
            fontSize = 20.sp
        )
        Spacer(Modifier.height(20.dp))

        SimpleText(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
            textAlign = TextAlign.Start, // Alineado a la izquierda
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal
        )
        Spacer(Modifier.height(70.dp))

        RoundedInputField("Enter email address", "example@example.com", labelPaddingLeft = 0.dp)

        Spacer(Modifier.height(45.dp))

        RoundedButton(
            "Next Step",
            onClick = {},
            width = 169.dp,
            height = 32.dp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            navController = navController,
            route = "SecurityPinScreen"
        )
        Spacer(Modifier.height(110.dp))
        RoundedButton(
            "Sign Up",
            backgroundColor = LightGreen,
            onClick = {},
            width = 169.dp,
            height = 32.dp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            navController = navController,
            route = "CreateAccountScreen"
        )
        Spacer(Modifier.height(25.dp))
        FacebookGoogle(navController)
    }
}
