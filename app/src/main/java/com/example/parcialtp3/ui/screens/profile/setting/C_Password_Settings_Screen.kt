package com.example.parcialtp3.ui.screens.profile.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.PasswordInputField

@Composable
fun C_Password_Settings_Screen(
    navController: NavHostController,
    onBack: () -> Unit = { navController.popBackStack() },
    onChangePassword: () -> Unit = {}
) {
    var current by remember { mutableStateOf("") }
    var newPass by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf("") }

    BackgroundScaffold(
        navController = navController,
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                title = "Password Settings",
                navController = navController,
                onBackClick = onBack
            )
        },
        panelContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(12.dp))

                PasswordInputField(
                    label = "Current Password",
                    value = current,
                    onValueChange = { current = it }
                )
                Spacer(Modifier.height(16.dp))

                PasswordInputField(
                    label = "New Password",
                    value = newPass,
                    onValueChange = { newPass = it }
                )
                Spacer(Modifier.height(16.dp))

                PasswordInputField(
                    label = "Confirm New Password",
                    value = confirm,
                    onValueChange = { confirm = it }
                )

                Spacer(Modifier.height(60.dp))

                Button(
                    onClick = { onChangePassword() },
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CaribbeanGreen,
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        text = "Change Password",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Spacer(Modifier.height(24.dp))
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true, name = "C - Password Settings")
@Composable
private fun Preview_C_Password_Settings() {
    val nav = rememberNavController()
    C_Password_Settings_Screen(navController = nav)
}
