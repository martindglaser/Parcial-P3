package com.example.parcialtp3.ui.screens.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.parcialtp3.ui.poppinsFamily

@Composable
fun OnBoardingAScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF002B28)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 60.dp)
        ) {
            // Título
            Text(
                text = "Welcome To\nExpense Manager",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = poppinsFamily
            )

            // Imagen
            Image(
                painter = painterResource(id = R.drawable.onboarding_coins),
                contentDescription = "Coins illustration",
                modifier = Modifier
                    .size(220.dp)
                    .padding(vertical = 24.dp)
            )

            // Botón Next
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = { navController.navigate("onboarding_b") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Text("Next", color = Color.White, fontWeight = FontWeight.Bold)
                }
                // Indicadores de página
                Row(horizontalArrangement = Arrangement.Center) {
                    Text("•", color = Color.White, fontSize = 16.sp)
                    Text("○", color = Color.Gray, fontSize = 16.sp)
                }
            }
        }
    }
}
