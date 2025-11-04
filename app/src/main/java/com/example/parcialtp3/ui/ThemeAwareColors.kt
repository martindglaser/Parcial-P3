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
)

object ThemeAwareColors {
    @Composable
    fun getColors(): AppThemeColors {
        val themeViewModel: ThemeViewModel = viewModel()
        val isDarkMode by themeViewModel.darkThemeEnabled.collectAsState()



        return AppThemeColors(
            normalText = if (isDarkMode) Honeydew else Void,
            highlightText = if (isDarkMode) OceanBlue else CaribbeanGreen ,
            highlightText2 = if (isDarkMode) VividBlue else CaribbeanGreen,
            headerBackground = if (isDarkMode) FenceGreen else CaribbeanGreen,
            contentBackground = if (isDarkMode) Cyprus else Honeydew,
            transactionsHeaderSubTitle = if (isDarkMode) LightGreen else Void,
        )
    }
}