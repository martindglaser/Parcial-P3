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
)

object ThemeAwareColors {
    @Composable
    fun getColors(): AppThemeColors {
        val themeViewModel: ThemeViewModel = viewModel()
        val isDarkMode by themeViewModel.darkThemeEnabled.collectAsState()

        val normalText = if (isDarkMode) Honeydew else Void
        val highlightText = if (isDarkMode) OceanBlue else CaribbeanGreen
        val highlightText2 = if (isDarkMode) VividBlue else CaribbeanGreen
        val headerBackground = if (isDarkMode) FenceGreen else CaribbeanGreen
        val contentBackground = if (isDarkMode) FenceGreen else CaribbeanGreen

        return AppThemeColors(
            normalText = normalText,
            highlightText = highlightText,
            highlightText2 = highlightText2,
            headerBackground = headerBackground,
            contentBackground = contentBackground
        )
    }
}