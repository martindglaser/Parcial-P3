package com.example.parcialtp3.ui.screens.loginSignUp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun CreateAccountScreen(){
    BackgroundScaffold(
        headerHeight = 187.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = { Title() },
        panelContent = { Body() }
    )
}
@Composable
private fun Title() {
    TitleText("Create Account", color = Void, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 18.dp))
}
@Composable
private fun Body() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        RoundedInputField("Full Name", "example@example.com")
        Spacer(Modifier.height(15.dp))
        RoundedInputField("Email", "example@example.com")
        Spacer(Modifier.height(15.dp))
        RoundedInputField("Mobile Number", "+ 123 456 789")
        Spacer(Modifier.height(15.dp))
        RoundedInputField("Date of birth", "DD / MM /YYY")
        Spacer(Modifier.height(15.dp))
        RoundedPassInput()
        Spacer(Modifier.height(15.dp))
        RoundedPassInput(label = "Confirm Password")
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

        RoundedButton("Sign Up", onClick = {}, width = 207.dp, height = 45.dp)
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
            fontFamily = PoppinsFamily
        )
    }
}



