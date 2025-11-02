package com.example.parcialtp3.ui.screens.launch

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
fun LaunchScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF002B28)), // verde oscuro
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(id = R.drawable.ic_analysis),
                contentDescription = "FinWise logo",
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "FinWise",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF00C49F),
                fontFamily = poppinsFamily
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod.",
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 40.dp),
                fontFamily = poppinsFamily
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {navController.navigate("welcome") {
                        popUpTo("launch") { inclusive = true } // limpia el stack anterior
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00C49F)),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(48.dp)
            ) {
                Text("Log In", color = Color.Black, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("signup") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBFFFEF)), // color más claro
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(48.dp)
            ) {
                Text("Sign Up", color = Color.Black, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Forgot Password?",
                color = Color.White,
                fontSize = 13.sp,
                fontFamily = poppinsFamily
            )
        }
    }
}
