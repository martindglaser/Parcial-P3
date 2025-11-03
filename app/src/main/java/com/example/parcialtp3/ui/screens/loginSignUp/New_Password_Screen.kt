package com.example.parcialtp3.ui.screens.loginSignUp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.OceanBlue
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.FacebookGoogle
import com.example.parcialtp3.ui.components.PoppinsFamily
import com.example.parcialtp3.ui.components.RoundedButton
import com.example.parcialtp3.ui.components.RoundedInputField
import com.example.parcialtp3.ui.components.RoundedPassInput
import com.example.parcialtp3.ui.components.SimpleText
import com.example.parcialtp3.ui.components.TitleText

@Composable
fun NewPasswordScreen(
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
    TitleText("New password", color = Void, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 18.dp))
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