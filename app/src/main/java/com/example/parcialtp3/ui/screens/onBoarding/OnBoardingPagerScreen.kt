package com.example.parcialtp3.ui.screens.onBoarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.ui.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingPagerScreen(
    navController: NavHostController,
    nextRoute: String
) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Honeydew),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        // Slides
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            when (page) {
                0 -> OnBoardingAScreen(navController)
                1 -> OnBoardingBScreen(navController)
            }
        }

        // Indicador de burbujas manual
        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .height(20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(pagerState.pageCount) { index ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(if (pagerState.currentPage == index) 10.dp else 8.dp)
                        .background(
                            color = if (pagerState.currentPage == index) CaribbeanGreen else LightGreen,
                            shape = RoundedCornerShape(50)
                        )
                )
            }
        }

        // Botón Next / Continue
        Button(
            onClick = {
                if (pagerState.currentPage == pagerState.pageCount - 1) {
                    navController.navigate(nextRoute)
                } else {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = CaribbeanGreen),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(0.5f)
                .height(48.dp)
        ) {
            Text(
                text = if (pagerState.currentPage == pagerState.pageCount - 1) "Continue" else "Next",
                color = Honeydew,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}
