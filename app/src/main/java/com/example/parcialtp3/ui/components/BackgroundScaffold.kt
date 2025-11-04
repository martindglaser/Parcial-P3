package com.example.parcialtp3.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isSpecified
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Cyprus
import com.example.parcialtp3.ui.FenceGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.screens.profile.ThemeViewModel

@Composable
fun BackgroundScaffold(
    modifier: Modifier = Modifier,
    headerHeight: Dp = 220.dp,
    whiteHeight: Dp = Dp.Unspecified,
    overlapRoundness: Dp = 48.dp,
    overlapOffset: Dp = 8.dp,
    headerContent: @Composable () -> Unit = {},
    panelContent: @Composable () -> Unit = {}
) {
    val themeViewModel: ThemeViewModel = viewModel()
    val isDarkMode = themeViewModel.darkThemeEnabled.collectAsState().value

    val panelColor = if (isDarkMode) Cyprus else Honeydew
    val backgroundColor = if (isDarkMode) FenceGreen else CaribbeanGreen

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        // HEADER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(headerHeight),
            contentAlignment = Alignment.TopCenter
        ) {
            Box(modifier = Modifier.padding(top = 60.dp)) {
                headerContent()
            }
        }

        // PANEL (parte inferior)
        val panelModifier = if (whiteHeight.isSpecified) {
            Modifier
                .fillMaxWidth()
                .height(whiteHeight)
        } else {
            Modifier.fillMaxSize()
        }

        Surface(
            color = panelColor,
            shape = RoundedCornerShape(topStart = overlapRoundness, topEnd = overlapRoundness),
            modifier = panelModifier
                .padding(top = headerHeight - overlapOffset)
                .align(Alignment.TopCenter)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                Box(modifier = Modifier.padding(top = 20.dp)) {
                    panelContent()
                }
            }
        }
    }
}
