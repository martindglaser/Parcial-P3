package com.example.parcialtp3.ui.screens.loginSignUp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.parcialtp3.ui.components.*

@Composable
fun WelcomeScreen(navController: NavHostController) {
    BackgroundScaffold(
        headerHeight = 187.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = { TitleWithBack(navController) },
        panelContent = { Body(navController) }
    )
}

@Composable
private fun TitleWithBack(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Botón de retroceso
        IconButton(onClick = { navController.navigate("b_launch") }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Go back",
                tint = Color.Black
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Título centrado
        TitleText(
            text = "Welcome",
            color = Void,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Spacer(modifier = Modifier.width(48.dp)) // balance visual del ícono
    }
}

@Composable
private fun Body(navController: NavHostController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        RoundedInputField(
            label = "Username or Email",
            placeholder = "example@example.com",
            modifier = Modifier.padding(top = 60.dp)
        )
        Spacer(Modifier.height(30.dp))
        RoundedPassInput()
        Spacer(Modifier.height(80.dp))
        RoundedButton(
            text = "Log In",
            width = 207.dp,
            height = 45.dp,
            backgroundColor = CaribbeanGreen,
            onClick = { /* TODO: agregar navegación al onboarding */ }
        )
        Spacer(Modifier.height(15.dp))
        SimpleText("Forgot Password?", color = Void, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        Spacer(Modifier.height(15.dp))

        RoundedButton(
            text = "Sign Up",
            width = 207.dp,
            height = 45.dp,
            backgroundColor = LightGreen,
            onClick = {}
        )
        Spacer(Modifier.height(25.dp))
        Text(
            text = buildAnnotatedString {
                pushStyle(SpanStyle(color = Void))
                append("Use ")
                withStyle(style = SpanStyle(color = OceanBlue)) {
                    append("Fingerprint")
                }
                append(" To Access")
                pop()
            },
            fontFamily = PoppinsFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
        Spacer(Modifier.height(25.dp))
        FacebookGoogle()
    }
}
