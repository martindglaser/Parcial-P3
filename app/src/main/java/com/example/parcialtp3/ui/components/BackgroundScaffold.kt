package com.example.parcialtp3.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isSpecified
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew

@Composable
fun BackgroundScaffold(
    modifier: Modifier = Modifier,
    headerHeight: Dp = 220.dp,
    whiteHeight: Dp = Dp.Unspecified,
    overlapRoundness: Dp = 48.dp,
    overlapOffset: Dp = 8.dp,
    headerColor: Color = CaribbeanGreen,
    panelColor: Color = Honeydew,
    headerContent: @Composable () -> Unit = {}, //ENVIAR COMPOSABLE CON TODO LO QUE HAYA EN EL HEADER (PARTE TURQUESA)
    panelContent: @Composable () -> Unit = {} //ENVIAR COMPOSABLE CON TODO LO QUE HAYA EN EL BODY (PARTE BLANCA)
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(headerColor)
    ) {
        // Contenido del HEADER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(headerHeight),
            contentAlignment = Alignment.TopCenter
        ) {
            Box(modifier = Modifier.padding(top = 60.dp)) { //PADDING SUPERIOR INCORPORADO DE 60PX
                headerContent()
            }
        }

        // PANEL claro redondeado
        val panelModifier = if (whiteHeight.isSpecified) {
            Modifier
                .fillMaxWidth()
                .height(whiteHeight)
        } else {
            Modifier
                .fillMaxSize()
        }

        Surface(
            color = panelColor,
            shape = RoundedCornerShape(topStart = overlapRoundness, topEnd = overlapRoundness),
            modifier = panelModifier
                .padding(top = headerHeight - overlapOffset)
                .align(Alignment.TopStart)
        ) {
            // Contenedor del contenido del PANEL
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                Box(modifier = Modifier.padding(top = 20.dp)) {
                    panelContent()
                }
            }
        }
    }
}