package com.example.parcialtp3.ui.screens.profile.security

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar

@Composable
fun B_Change_Pin_Screen(
    onBack: () -> Unit = {},
    onNotifications: () -> Unit = {},
    onConfirm: () -> Unit = {}
) {
    BackgroundScaffold(
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                title = "Change Pin",
                onBackClick = onBack,
                onNotificationClick = onNotifications
            )
        },
        panelContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(Modifier.height(20.dp))

                var currentPin by remember { mutableStateOf("") }
                var newPin by remember { mutableStateOf("") }
                var confirmPin by remember { mutableStateOf("") }

                PinField(
                    label = "Current Pin",
                    value = currentPin,
                    onValueChange = { currentPin = it }
                )
                Spacer(Modifier.height(20.dp))

                PinField(
                    label = "New Pin",
                    value = newPin,
                    onValueChange = { newPin = it }
                )
                Spacer(Modifier.height(20.dp))

                PinField(
                    label = "Confirm Pin",
                    value = confirmPin,
                    onValueChange = { confirmPin = it }
                )

                Spacer(Modifier.height(32.dp))

                Button(
                    onClick = onConfirm,
                    modifier = Modifier
                        .widthIn(min = 220.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CaribbeanGreen,
                        contentColor = Color.Black
                    )
                ) {
                    Text("Change Pin", style = MaterialTheme.typography.bodyLarge)
                }

                Spacer(Modifier.height(24.dp))
            }
        }
    )
}

@Composable
private fun PinField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(Modifier.fillMaxWidth()) {
        Text(label, style = MaterialTheme.typography.bodyMedium, color = Void)
        Spacer(Modifier.height(6.dp))

        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.eyepass),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(18.dp)
                )
            },
            shape = RoundedCornerShape(18.dp),
            textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = LightGreen,
                unfocusedContainerColor = LightGreen,
                disabledContainerColor = LightGreen,
                cursorColor = Void,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedTextColor = Void,
                unfocusedTextColor = Void
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Change Pin")
@Composable
private fun PreviewChangePin() {
    B_Change_Pin_Screen()
}
