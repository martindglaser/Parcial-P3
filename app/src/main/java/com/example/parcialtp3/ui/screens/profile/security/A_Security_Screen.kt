package com.example.parcialtp3.ui.screens.profile.security

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.LightGreen

@Composable
fun A_Security_Screen(
    navController: NavHostController,
    onChangePin: () -> Unit = {},
    onFingerprint: () -> Unit = {},
    onTerms: () -> Unit = {}
) {
    BackgroundScaffold(
        navController = navController,
        headerHeight = 200.dp,
        whiteHeight = androidx.compose.ui.unit.Dp.Unspecified,
        headerContent = {
            HeaderBar(
                navController = navController,
                title = "Security",
                onBackClick = { navController.popBackStack() }
            )
        },
        panelContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(Modifier.height(12.dp))
                Text(
                    text = "Security",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Void
                )
                Spacer(Modifier.height(8.dp))

                //Lista de opciones
                SecurityOptionRow(
                    label = "Change Pin",
                    onClick = onChangePin
                )
                SecurityDivider()

                SecurityOptionRow(
                    label = "Fingerprint",
                    onClick = onFingerprint
                )
                SecurityDivider()

                SecurityOptionRow(
                    label = "Terms And Conditions",
                    onClick = onTerms
                )
                SecurityDivider()
            }
        }
    )
}

@Composable
private fun SecurityOptionRow(
    label: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 60.dp)
            .clickable(onClick = onClick)
            .padding(vertical = 22.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = Void,
            modifier = Modifier.weight(1f)
        )

        Icon(
            painter = painterResource(id = R.drawable.icon_chevron_right),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = androidx.compose.ui.graphics.Color.Unspecified
        )
    }
}

@Composable
private fun SecurityDivider() {
    HorizontalDivider(
        modifier = Modifier,
        thickness = 1.dp,
        color = LightGreen.copy(alpha = 0.7f)
    )
}
