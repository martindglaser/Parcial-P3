package com.example.parcialtp3.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.*
import com.example.parcialtp3.ui.poppinsFamily

@Composable
fun Edit_Profile_Screen(navController: NavHostController,viewModel: ThemeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val pushNotificationsEnabled = remember { mutableStateOf(true) }
    val darkThemeState = viewModel.darkThemeEnabled.collectAsState()

    BackgroundScaffold(
        navController = navController,
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                title = "Edit My Profile",
                navController = navController,
                onBackClick = { navController.popBackStack() }
            )
        },
        panelContent = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(Modifier.height(50.dp))
                DisplayName("25030024", "John Smith")

                Spacer(Modifier.height(30.dp))

                SimpleText(
                    text = "Account Settings",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp)
                )

                Spacer(Modifier.height(25.dp))
                RoundedInputField("Username", "John Smith")
                Spacer(Modifier.height(20.dp))
                RoundedInputField("Phone", "+44 555 5555 55")
                Spacer(Modifier.height(20.dp))
                RoundedInputField("Email Address", "example@example.com")

                Spacer(Modifier.height(35.dp))
                SettingsSwitchRow(
                    label = "Push Notifications",
                    checked = pushNotificationsEnabled.value,
                    onCheckedChange = { pushNotificationsEnabled.value = it }
                )

                SettingsSwitchRow(
                    label = "Turn Dark Theme",
                    checked = darkThemeState.value,
                    onCheckedChange = { viewModel.toggleTheme(it) }
                )

                Spacer(Modifier.height(20.dp))

                RoundedButton(
                    text = "Update Profile",
                    width = 207.dp,
                    height = 45.dp,
                    backgroundColor = CaribbeanGreen,
                    onClick = {},
                    navController = navController
                )
            }
        }
    )

    ImagenFlotadora(135.dp, R.drawable.profile_picture)
}
