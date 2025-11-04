package com.example.parcialtp3.ui.screens.loginSignUp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.ui.VividBlue
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.PoppinsFamily
import com.example.parcialtp3.ui.components.RoundedButton
import com.example.parcialtp3.ui.components.RoundedInputField
import com.example.parcialtp3.ui.components.RoundedPassInput
import com.example.parcialtp3.ui.components.TitleText
import com.example.parcialtp3.ui.viewmodels.CreateAccountViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.navigation.NavHostController

@Composable
fun CreateAccountScreen(
    vm: CreateAccountViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var pass1 by remember { mutableStateOf("") }
    var pass2 by remember { mutableStateOf("") }

    BackgroundScaffold(
        headerHeight = 187.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = { Title() },
        panelContent = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                RoundedInputField("Full Name", "John Doe", onTextChanged = { fullName = it })
                Spacer(Modifier.height(15.dp))
                RoundedInputField("Email", "example@example.com", onTextChanged = { email = it })
                Spacer(Modifier.height(15.dp))
                RoundedInputField("Mobile Number", "+ 123 456 789", onTextChanged = { phone = it })
                Spacer(Modifier.height(15.dp))
                RoundedInputField("Date of birth", "DD / MM / YYY", onTextChanged = { dob = it })
                Spacer(Modifier.height(15.dp))
                RoundedPassInput(onTextChanged = { pass1 = it })
                Spacer(Modifier.height(15.dp))
                RoundedPassInput(label = "Confirm Password", onTextChanged = { pass2 = it })
                Spacer(Modifier.height(20.dp))
                Text(
                    text = buildAnnotatedString {
                        append("By continuing, you agree to\n")

                        withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                            append("Terms of Use")
                        }

                        append(" and ")

                        withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                            append("Privacy Policy.")
                        }
                    },
                    color = Void,
                    fontFamily = PoppinsFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(15.dp))
                RoundedButton(
                    "Sign Up",
                    onClick = { vm.createAccount(fullName, email, phone, pass2) },
                    width = 207.dp, height = 45.dp,
                    navController = navController,
                    route = "HomeScreen"
                )

                val lastUser by vm.lastUser.collectAsState()
                lastUser?.let {}

                Spacer(Modifier.height(15.dp))
                Text(
                    buildAnnotatedString {
                        append("Already have an account? ")
                        withStyle(
                            style = SpanStyle(
                                color = VividBlue,
                            )
                        ) {
                            append("Sign In")
                        }
                    },
                    fontSize = 13.sp,
                    color = Void,
                    fontWeight = FontWeight.Light,
                    fontFamily = PoppinsFamily,
                    modifier = Modifier.clickable(
                        onClick = {
                            navController.navigate("WelcomeScreen")
                        }
                    )
                )
            }
        }
    )
}
@Composable
private fun Title() {
    TitleText("Create Account", fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 18.dp))
}