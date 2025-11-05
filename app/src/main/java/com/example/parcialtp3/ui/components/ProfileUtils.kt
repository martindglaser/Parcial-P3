package com.example.parcialtp3.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Cyprus
import com.example.parcialtp3.ui.FenceGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.poppinsFamily
import com.example.parcialtp3.ui.screens.profile.ThemeViewModel

@Composable
fun ProfileOption(
    iconRes: Int,
    label: String,
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp, vertical = 10.dp)
            .clickable(enabled = onClick != null) { onClick?.invoke() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(65.dp)
                .background(Color.Transparent, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                modifier = Modifier.size(65.dp)
            )
        }

        Spacer(Modifier.width(16.dp))

        SimpleText(
            text = label,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ImagenFlotadora(altura: Dp,imagen: Int){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(imagen),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .offset(y = altura) // posición exacta para que quede centrada entre header y panel
                .size(120.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun DisplayName(id: String, name: String){
    val themeViewModel: ThemeViewModel = viewModel()
    val isDarkMode = themeViewModel.darkThemeEnabled.collectAsState().value
    val textColor = if (isDarkMode) Honeydew else Void


    SimpleText(
        text = name,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    )
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("ID: ")
            }
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append(id)
            }
        },
        fontSize = 14.sp,
        color = textColor,
        fontFamily = poppinsFamily
    )
}


@Composable
fun SettingsSwitchRow(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SimpleText(
            text = label,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = androidx.compose.material3.SwitchDefaults.colors(
                checkedThumbColor = Honeydew,
                checkedTrackColor = CaribbeanGreen,
                uncheckedThumbColor = Honeydew,
                uncheckedTrackColor = Color(0xFFB9F5E3)
            )
        )
    }
}
