package com.example.parcialtp3.ui.screens.profile.security

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar

@Composable
fun D_Fingerprint_Screen(
    navController: NavHostController,
    onTapExisting: () -> Unit = {},
    onAddFingerprint: () -> Unit = {}
) {
    BackgroundScaffold(
        navController = navController,
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                navController = navController,
                title = "Fingerprint",
                onBackClick = { navController.popBackStack() }
            )
        },
        panelContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(Modifier.height(16.dp))

                FingerprintRow(
                    leadingIconRes = R.drawable.fingerprint_lightblue,
                    label = "John Fingerprint",
                    onClick = onTapExisting,
                    iconSize = 75.dp
                )

                Spacer(Modifier.height(12.dp))

                FingerprintRow(
                    leadingIconRes = R.drawable.plus_lightblue,
                    label = "Add A Fingerprint",
                    onClick = onAddFingerprint,
                    iconSize = 75.dp
                )

            }
        }
    )
}

@Composable
private fun FingerprintRow(
    leadingIconRes: Int,
    label: String,
    onClick: () -> Unit,
    containerColor: Color = Honeydew,
    corner: Dp = 16.dp,
    iconSize: Dp = 40.dp,
    chevronSize: Dp = 18.dp
) {
    Surface(
        color = containerColor,
        shape = RoundedCornerShape(corner),
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(leadingIconRes),
                contentDescription = null,
                modifier = Modifier
                    .size(iconSize)
                    .background(color = Honeydew, shape = RoundedCornerShape(12.dp))
                    .padding(8.dp)
            )
            Spacer(Modifier.width(12.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                color = Void,
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = painterResource(R.drawable.icon_chevron_right),
                contentDescription = null,
                modifier = Modifier.size(chevronSize)
            )
        }
    }
}
