package com.example.parcialtp3.ui.screens.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.*
import com.example.parcialtp3.ui.components.BackgroundScaffold

@Composable
fun OnBoardingBScreen(navController: NavHostController, nextRoute: String) {
    BackgroundScaffold(
        navController = navController,
        displayBottomNavBar = false,
        headerHeight = 308.dp,
        headerContent = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                Text(
                    text = "Are You Ready To\nTake Control Of\nYour Finances?",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Void,
                    textAlign = TextAlign.Center,
                    fontFamily = poppinsFamily
                )
            }
        },
            panelContent = {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(
                            color = Honeydew,
                            shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 60.dp, bottom = 40.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.onboarding_phone),
                            contentDescription = "Phone illustration",
                            modifier = Modifier.size(280.dp)
                        )

                        Spacer(modifier = Modifier.height(35.dp))

                        // Texto "Next" que actúa como botón
                        Text(
                            text = "Next",
                            fontSize = 28.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppinsFamily,
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(nextRoute) {
                                        popUpTo("launch") { inclusive = true }
                                    }
                                }
                                .padding(bottom = 8.dp)
                        )
                    }
                }

        }
        )
}