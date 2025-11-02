package com.example.parcialtp3.ui.screens.profile.security

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.LargeFingerprintIcon

@Composable
fun F_Fingerprint_Add_Screen(
    onBack: () -> Unit = {},
    onNotifications: () -> Unit = {},
    onUseTouchId: () -> Unit = {}
) {
    BackgroundScaffold(
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                title = "Add Fingerprint",
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
                Spacer(Modifier.height(24.dp))

                // Ícono grande
                LargeFingerprintIcon()

                Spacer(Modifier.height(50.dp))

                // Título
                Text(
                    text = "Use Fingerprint  To Access",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    color = Void
                )

                Spacer(Modifier.height(20.dp))

                // Descripción (placeholder)
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Void.copy(alpha = 0.8f),
                    lineHeight = 18.sp,
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(horizontal = 6.dp),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )

                Spacer(Modifier.height(70.dp))

                Button(
                    onClick = onUseTouchId,
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LightGreen,
                        contentColor = Void
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
                ) {
                    Text(
                        text = "Use Touch Id",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }

                Spacer(Modifier.height(24.dp))
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true, name = "Add Fingerprint")
@Composable
private fun Preview_F_Add() {
    F_Fingerprint_Add_Screen()
}
