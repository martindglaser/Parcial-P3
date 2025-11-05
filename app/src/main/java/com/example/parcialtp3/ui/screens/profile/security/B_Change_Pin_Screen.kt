package com.example.parcialtp3.ui.screens.profile.security

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.PasswordInputField

@Composable
fun B_Change_Pin_Screen(
    navController: NavHostController,
    onConfirm: () -> Unit = {}
) {
    BackgroundScaffold(
        navController = navController,
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                navController = navController,
                title = "Change Pin",
                onBackClick = { navController.popBackStack() }
            )
        },
        panelContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(Modifier.height(16.dp))

                var currentPin by remember { mutableStateOf("") }
                var newPin by remember { mutableStateOf("") }
                var confirmPin by remember { mutableStateOf("") }

                PasswordInputField(
                    label = "Current Pin",
                    value = currentPin,
                    onValueChange = { currentPin = it }
                )
                Spacer(Modifier.height(20.dp))

                PasswordInputField(
                    label = "New Pin",
                    value = newPin,
                    onValueChange = { newPin = it }
                )
                Spacer(Modifier.height(20.dp))

                PasswordInputField(
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
