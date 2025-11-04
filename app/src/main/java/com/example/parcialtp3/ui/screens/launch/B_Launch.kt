package com.example.parcialtp3.ui.screens.launch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.*

@Composable
fun LaunchScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Honeydew),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(id = R.drawable.ic_grafico),
                contentDescription = "FinWise logo",
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "FinWise",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = CaribbeanGreen,
                fontFamily = poppinsFamily
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod.",
                fontSize = 14.sp,
                color = Void,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 40.dp),
                fontFamily = poppinsFamily
            )

            Spacer(modifier = Modifier.height(32.dp))

            // LOG IN → pasa por OnBoarding y luego a WelcomeScreen
            Button(
                onClick = {
                    navController.navigate("OnBoardingPagerScreen?next=WelcomeScreen") {
                        popUpTo("launch") { inclusive = true }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = CaribbeanGreen),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(48.dp)
            ) {
                Text("Log In", color = Honeydew, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // SIGN UP → pasa por OnBoarding y luego a CreateAccountScreen
            Button(
                onClick = {
                    navController.navigate("OnBoardingPagerScreen?next=CreateAccountScreen") {
                        popUpTo("launch") { inclusive = true }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = LightGreen),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(48.dp)
            ) {
                Text("Sign Up", color = FenceGreen, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // FORGOT PASSWORD
            Text(
                text = "Forgot Password?",
                color = OceanBlue,
                fontSize = 13.sp,
                fontFamily = poppinsFamily,
                modifier = Modifier.clickable {
                    navController.navigate("ForgotPasswordScreen")
                }
            )
        }
    }
}
