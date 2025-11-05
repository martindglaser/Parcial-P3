package com.example.parcialtp3.ui.screens.loginSignUp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.parcialtp3.ui.ThemeAwareColors
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.FacebookGoogle
import com.example.parcialtp3.ui.components.PoppinsFamily
import com.example.parcialtp3.ui.components.RoundedButton
import com.example.parcialtp3.ui.components.RoundedInputField
import com.example.parcialtp3.ui.components.RoundedPassInput
import com.example.parcialtp3.ui.components.SimpleText
import com.example.parcialtp3.ui.components.TitleText
import com.example.parcialtp3.ui.viewmodels.WelcomeViewModel

@Composable
fun WelcomeScreen(
    vm: WelcomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController
) {
    val themeColors = ThemeAwareColors.getColors()

    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    BackgroundScaffold(
        navController = navController,
        displayBottomNavBar = false,
        headerHeight = 187.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = { Title() },
        panelContent = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                RoundedInputField(
                    label = "Username or Email",
                    placeholder = "example@example.com",
                    modifier = Modifier.padding(top = 60.dp),
                    onTextChanged = { email = it }
                )
                Spacer(Modifier.height(30.dp))
                RoundedPassInput(onTextChanged = { pass = it })
                Spacer(Modifier.height(80.dp))
                RoundedButton(
                    text = "Log In",
                    width = 207.dp,
                    height = 45.dp,
                    backgroundColor = CaribbeanGreen,
                    onClick = { vm.login(email, pass) },
                    navController = navController,
                    route = "HomeScreen"
                )
                val token by vm.token.collectAsState()
                token?.let {}

                Spacer(Modifier.height(15.dp))
                SimpleText(
                    "Forgot Password?",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    navController = navController,
                    route = "ForgotPasswordScreen"
                )
                Spacer(Modifier.height(15.dp))

                RoundedButton(
                    text = "Sign Up",
                    width = 207.dp,
                    height = 45.dp,
                    backgroundColor = LightGreen,
                    onClick = {},
                    navController = navController,
                    route = "CreateAccountScreen"
                )
                Spacer(Modifier.height(25.dp))
                Text(
                    text = buildAnnotatedString {
                        pushStyle(SpanStyle(color = themeColors.normalText))
                        append("Use ")
                        withStyle(style = SpanStyle(color = themeColors.highlightText)) {
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
                FacebookGoogle(navController)
            }
        }
    )
}

@Composable
private fun Title() {
    TitleText("Welcome", fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 18.dp))
}
