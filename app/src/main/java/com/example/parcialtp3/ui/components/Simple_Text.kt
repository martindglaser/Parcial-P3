package com.example.parcialtp3.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.FenceGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.screens.profile.ThemeViewModel

val PoppinsFamily = FontFamily(
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

@Composable
fun SimpleText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Start,
    navController: NavHostController? = null,
    route: String? = null
) {
    val themeViewModel: ThemeViewModel = viewModel()
    val isDarkMode = themeViewModel.darkThemeEnabled.collectAsState().value

    val textColor = if (isDarkMode) Honeydew else Void
    Text(
        text = text,
        modifier = modifier.clickable(
            enabled = navController != null && route != null,
            onClick = {
                route?.let {
                    navController?.navigate(it)
                }
            }
        ),
        color = textColor,
        fontSize = fontSize,
        fontFamily = PoppinsFamily,
        fontWeight = fontWeight,
        textAlign = textAlign
    )
}
