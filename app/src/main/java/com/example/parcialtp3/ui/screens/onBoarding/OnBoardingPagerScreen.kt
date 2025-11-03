package com.example.parcialtp3.ui.screens.onBoarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.poppinsFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingPagerScreen(navController: NavHostController) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CaribbeanGreen),
        contentAlignment = Alignment.BottomCenter
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when (page) {
                0 -> OnBoardingAScreen(navController)
                1 -> OnBoardingBScreen(navController)
            }
        }

        // Indicadores de página (reemplaza los puntos individuales dentro de cada pantalla)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
                .background(Honeydew.copy(alpha = 0.6f), shape = androidx.compose.foundation.shape.RoundedCornerShape(50))
                .padding(horizontal = 20.dp, vertical = 6.dp)
        ) {
            repeat(2) { index ->
                val isSelected = pagerState.currentPage == index
                Text(
                    text = if (isSelected) "•" else "○",
                    fontSize = if (isSelected) 22.sp else 18.sp,
                    color = if (isSelected) CaribbeanGreen else Void,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFamily,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        }
    }
}
