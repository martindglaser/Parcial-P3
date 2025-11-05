package com.example.parcialtp3.ui.screens.profile.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.ParcialTP3Theme
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar

@Composable
fun A_Settings_Screen(
    navController: NavHostController,
    onBack: () -> Unit = { navController.popBackStack() },
    onNotification: () -> Unit = {},
    onPassword: () -> Unit = {},
    onDeleteAccount: () -> Unit = {}
) {
    BackgroundScaffold(
        navController = navController,
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                title = "Settings",
                navController = navController,
                onBackClick = onBack
            )
        },
        panelContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(Modifier.height(12.dp))

                SettingsRow(
                    iconRes = R.drawable.icon_notification_caribbeangreen,
                    label = "Notification Settings",
                    onClick = onNotification
                )
                SettingsDivider()

                SettingsRow(
                    iconRes = R.drawable.icon_key_caribbeangreen,
                    label = "Password Settings",
                    onClick = onPassword
                )
                SettingsDivider()

                SettingsRow(
                    iconRes = R.drawable.icon_notification_caribbeangreen,
                    label = "Delete Account",
                    onClick = onDeleteAccount
                )
                SettingsDivider()
            }
        }
    )
}

@Composable
private fun SettingsRow(
    iconRes: Int,
    label: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 64.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier
                .size(45.dp)
                .padding(end = 12.dp)
        )

        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            color = Void,
            modifier = Modifier.weight(1f)
        )

        Image(
            painter = painterResource(R.drawable.icon_chevron_right),
            contentDescription = null,
            modifier = Modifier.size(18.dp)
        )
    }
}

@Composable
private fun SettingsDivider() {
    HorizontalDivider(
        thickness = 1.dp,
        color = LightGreen.copy(alpha = 0.7f)
    )
}

@Preview(showBackground = true, showSystemUi = true, name = "Settings")
@Composable
private fun Preview_A_Settings_Screen() {
    val nav = rememberNavController()
    ParcialTP3Theme {
        A_Settings_Screen(navController = nav)
    }
}