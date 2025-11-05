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
import androidx.navigation.NavHostController
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Cyprus
import com.example.parcialtp3.ui.FenceGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.screens.profile.ThemeViewModel
import com.example.parcialtp3.ui.ThemeAwareColors

@Composable
fun BackgroundScaffold(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    headerHeight: Dp = 220.dp,
    whiteHeight: Dp = Dp.Unspecified,
    overlapRoundness: Dp = 48.dp,
    overlapOffset: Dp = 8.dp,
    headerContent: @Composable () -> Unit = {},
    panelContent: @Composable () -> Unit = {},
    current: String = "",
    displayBottomNavBar: Boolean = true
) {
    val themeColors = ThemeAwareColors.getColors()
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(themeColors.headerBackground)
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
            color = themeColors.contentBackground,
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
        if(displayBottomNavBar) {
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(),
                color = Color.Transparent,
                shadowElevation = 12.dp
            ) {
                BottomNavBar(navController = navController, current = current)
            }
        }
    }
}
