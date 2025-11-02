package com.example.parcialtp3.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen

/**
 * Ícono circular grande fijo para fingerprint.
 * - Diámetro círculo: 180.dp
 * - Fondo: CaribbeanGreen
 * - Ícono: R.drawable.icon_fingerprint a 108.dp
 */
@Composable
fun LargeFingerprintIcon() {
    Box(
        modifier = Modifier
            .size(180.dp)
            .background(CaribbeanGreen, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.icon_fingerprint),
            contentDescription = null,
            modifier = Modifier.size(180.dp)
        )
    }
}
