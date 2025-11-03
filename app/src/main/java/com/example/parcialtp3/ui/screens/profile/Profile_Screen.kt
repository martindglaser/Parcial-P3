package com.example.parcialtp3.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.OceanBlue
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.CabeceraTransactions
import com.example.parcialtp3.ui.components.DisplayName
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.ImagenFlotadora
import com.example.parcialtp3.ui.components.MonthSection
import com.example.parcialtp3.ui.components.ProfileOption
import com.example.parcialtp3.ui.components.RoundedButton
import com.example.parcialtp3.ui.components.TarjetaBalance
import com.example.parcialtp3.ui.components.Transaction
import com.example.parcialtp3.ui.poppinsFamily

@Composable
fun Profile_Screen() {
    val showDialog = remember { mutableStateOf(false) }

    BackgroundScaffold(
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(title = "Profile")
        },
        panelContent = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(Modifier.height(50.dp))

                DisplayName("25030024","John Smith")

                Spacer(Modifier.height(20.dp))

                ProfileOption(R.drawable.icon_profile, "Edit Profile")
                ProfileOption(R.drawable.icon_security, "Security")
                ProfileOption(R.drawable.icon_setting, "Setting")
                ProfileOption(R.drawable.icon_help, "Help")
                ProfileOption(
                    iconRes = R.drawable.icon_logout,
                    label = "Logout",
                    onClick = { showDialog.value = true }
                )
            }
        }
    )


    ImagenFlotadora(135.dp,R.drawable.profile_picture)


   if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            confirmButton = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    RoundedButton(
                        text = "Yes, End Session",
                        width = 207.dp,
                        height = 45.dp,
                        backgroundColor = CaribbeanGreen,
                        textColor = Color.White,
                        onClick = {
                            showDialog.value = false
                            // lógica de logout
                        }
                    )

                    Spacer(Modifier.height(10.dp))

                    RoundedButton(
                        text = "Cancel",
                        width = 207.dp,
                        height = 45.dp,
                        backgroundColor = LightGreen,
                        textColor = Void,
                        onClick = {
                            showDialog.value = false
                        }
                    )
                }
            },
            title = {
                Text(
                    text = "End Session",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Void,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            text = {
                Text(
                    text = "Are you sure you want to log out?",
                    textAlign = TextAlign.Center,
                    color = Void,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            containerColor = Color.White,
            shape = RoundedCornerShape(20.dp)
        )
  }
}




