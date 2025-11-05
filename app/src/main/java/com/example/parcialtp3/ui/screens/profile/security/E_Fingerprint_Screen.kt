package com.example.parcialtp3.ui.screens.profile.security

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.ui.components.LargeFingerprintIcon

@Composable
fun E_Fingerprint_Screen(
    navController: NavHostController,
    title: String = "Jhon Fingerprint",
    onDelete: () -> Unit = {}
) {
    BackgroundScaffold(
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                navController = navController,
                title = title,
                onBackClick = { navController.popBackStack() },
            )
        },
        panelContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(28.dp))

                LargeFingerprintIcon()

                Spacer(Modifier.height(20.dp))

                Surface(
                    color = LightGreen,
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(40.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = title,
                            color = Void,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                }


                Spacer(Modifier.height(90.dp))

                Button(
                    onClick = onDelete,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CaribbeanGreen,
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        "Delete",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 18.sp,               // ↑ antes default (~16sp)
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }

                Spacer(Modifier.height(24.dp))
            }
        }
    )
}
