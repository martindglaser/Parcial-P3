package com.example.parcialtp3.ui.screens.loginSignUp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.LightBlue
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.OceanBlue
import com.example.parcialtp3.ui.VividBlue
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold

@Composable
fun WelcomeScreen() {
    BackgroundScaffold(
        headerHeight = 220.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = { },
        panelContent = { Welcome() }
    )
}

@Composable
fun Welcome() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Forgot Password?",
            color = Void,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {},
            fontSize = 13.sp
        )

        Spacer(Modifier.height(8.dp))

        Spacer(Modifier.height(16.dp))
        val fp = buildAnnotatedString {
            append("Use ")
            withStyle(SpanStyle(color = Void, fontWeight = FontWeight.SemiBold)) {
                append("Fingerprint")
            }
            append("  To Access")
        }
        Text(
            text = fp,
            color = Void,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {},
            fontSize = 13.sp
        )

        Spacer(Modifier.height(20.dp))
        Text(
            "or sign up with",
            color = Void,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(10.dp))

        Spacer(Modifier.height(16.dp))
        Text(
            text = buildAnnotatedString {
                append("Don't have an account? ")
                withStyle(SpanStyle(color = Void, fontWeight = FontWeight.SemiBold)) {
                    append("Sign Up")
                }
            },
            color = LightBlue,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {}
        )
    }
}