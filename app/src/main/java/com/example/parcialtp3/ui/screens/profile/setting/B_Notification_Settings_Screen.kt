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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar

@Composable
fun B_Notification_Settings_Screen(
    navController: NavHostController,
    onBack: () -> Unit = { navController.popBackStack() }
) {
    BackgroundScaffold(
        navController = navController,
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                title = "Notification Settings",
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

                NotificationRow(label = "General Notification")
                SettingsDivider()

                NotificationRow(label = "Sound")
                SettingsDivider()

                NotificationRow(label = "Sound Call")
                SettingsDivider()

                NotificationRow(label = "Vibrate")
                SettingsDivider()

                NotificationRow(label = "Transaction Update")
                SettingsDivider()

                NotificationRow(label = "Expense Reminder")
                SettingsDivider()

                NotificationRow(label = "Budget Notifications")
                SettingsDivider()

                NotificationRow(label = "Low Balance Alerts")
                SettingsDivider()
            }
        }
    )
}

@Composable
private fun NotificationRow(
    label: String,
    initial: Boolean = false
) {
    var checked by rememberSaveable { mutableStateOf(initial) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            color = Void,
            modifier = Modifier.weight(1f)
        )

        ToggleIconSwitch(
            checked = checked,
            onToggle = { checked = !checked }
        )
    }
}

@Composable
private fun ToggleIconSwitch(
    checked: Boolean,
    onToggle: () -> Unit
) {
    Image(
        painter = painterResource(
            if (checked) R.drawable.icon_toggleswitch_active
            else R.drawable.icon_toggleswitch_inactive
        ),
        contentDescription = if (checked) "On" else "Off",
        modifier = Modifier
            .size(38.dp)
            .clickable { onToggle() }
    )
}

@Composable
private fun SettingsDivider() {
    HorizontalDivider(
        thickness = 1.dp,
        color = LightGreen.copy(alpha = 0.7f)
    )
}


@Preview(showBackground = true, showSystemUi = true, name = "Notification Settings")
@Composable
private fun Preview_B_Notification_Settings() {
    val nav = rememberNavController()
    B_Notification_Settings_Screen(navController = nav)
}
