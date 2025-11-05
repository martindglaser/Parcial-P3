package com.example.parcialtp3.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3.ui.screens.profile.ThemeViewModel

data class AppThemeColors(
    val normalText: Color,
    val highlightText: Color,
    val highlightText2: Color,
    val headerBackground: Color,
    val contentBackground: Color,
    val transactionsHeaderSubTitle: Color,
    val navBarColor: Color,
    val iconColorBottomNavBar: Color
)

object ThemeAwareColors {
    @Composable
    fun getColors(): AppThemeColors {
        val themeViewModel: ThemeViewModel = viewModel()
        val isDarkMode by themeViewModel.darkThemeEnabled.collectAsState()



        return AppThemeColors(
            normalText = if (isDarkMode) Honeydew else Void,
            highlightText = if (isDarkMode) CaribbeanGreen else OceanBlue ,
            highlightText2 = if (isDarkMode) CaribbeanGreen else VividBlue,
            headerBackground = if (isDarkMode) FenceGreen else CaribbeanGreen,
            contentBackground = if (isDarkMode) DarkTeal else Honeydew,
            transactionsHeaderSubTitle = if (isDarkMode) LightGreen else Void,
            iconColorBottomNavBar = if (isDarkMode) LightGreen else Void,
            navBarColor = if (isDarkMode) Cyprus else LightGreen
        )
    }
}