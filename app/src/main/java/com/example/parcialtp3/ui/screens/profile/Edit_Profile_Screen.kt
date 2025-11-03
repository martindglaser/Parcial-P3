package com.example.parcialtp3.ui.screens.profile


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.DisplayName
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.ImagenFlotadora
import com.example.parcialtp3.ui.components.RoundedButton
import com.example.parcialtp3.ui.components.RoundedInputField
import com.example.parcialtp3.ui.components.SettingsSwitchRow
import com.example.parcialtp3.ui.poppinsFamily


@Composable
fun Edit_Profile_Screen() {
    val pushNotificationsEnabled = remember { mutableStateOf(true) }
    val darkThemeEnabled = remember { mutableStateOf(false) }

    BackgroundScaffold(
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(title = "Edit My Profile")
        },
        panelContent = {
            // Parte blanca: contenido debajo de la foto
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(Modifier.height(50.dp)) // deja espacio para la imagen
                DisplayName("25030024","John Smith")

                Spacer(Modifier.height(30.dp))

                Text(
                    text = "Account Settings",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    fontFamily = poppinsFamily,
                    color = Void,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp)

                )
                Spacer(Modifier.height(25.dp))
                RoundedInputField("Username", "John Smith")
                Spacer(Modifier.height(20.dp))
                RoundedInputField("Phone", "+44 555 5555 55")
                Spacer(Modifier.height(20.dp))
                RoundedInputField("Email Adress", "example@example.com")

                Spacer(Modifier.height(35.dp))
                SettingsSwitchRow(
                    label = "Push Notifications",
                    checked = pushNotificationsEnabled.value,
                    onCheckedChange = { pushNotificationsEnabled.value = it }
                )

                SettingsSwitchRow(
                    label = "Turn Dark Theme",
                    checked = darkThemeEnabled.value,
                    onCheckedChange = { darkThemeEnabled.value = it }
                )

                Spacer(Modifier.height(20.dp))

                RoundedButton(
                    text = "Update Profile",
                    width = 207.dp,
                    height = 45.dp,
                    backgroundColor = CaribbeanGreen,
                    onClick = {}
                )
            }
        }
    )

    ImagenFlotadora(135.dp,R.drawable.profile_picture)
}




