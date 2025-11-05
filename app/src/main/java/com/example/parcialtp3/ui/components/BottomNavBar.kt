package com.example.parcialtp3.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.VerdeCaribeno
import com.example.parcialtp3.Brown
import com.example.parcialtp3.ui.Honeydew

@Composable
fun BottomNavBar(
    navController: NavHostController,
    current: String
) {
    Surface(
        color = Honeydew, // cubre el fondo entero
        shadowElevation = 8.dp,
        tonalElevation = 0.dp // mantiene limpio el color
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Honeydew,
                    shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                )
                .padding(vertical = 10.dp, horizontal = 24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val items = listOf(
                    Triple("transactions", R.drawable.ic_home, "Home"),
                    Triple("account_balance", R.drawable.ic_analysis, "Balance"),
                    Triple("favourites", R.drawable.ic_transaction, "Transaction"),
                    Triple("category", R.drawable.ic_category, "Category"),
                    Triple("profile", R.drawable.ic_profile, "Profile")
                )

                items.forEach { (route, iconResId, _) ->
                    val isSelected = current == route

                    Box(
                        modifier = Modifier
                            .size(46.dp)
                            .clip(CircleShape)
                            .background(
                                if (isSelected) VerdeCaribeno else Color.Transparent
                            )
                            .clickable {
                                navController.navigate(route) {
                                    popUpTo("HomeScreen") { inclusive = false }
                                    launchSingleTop = true
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = iconResId),
                            contentDescription = route,
                            tint = if (isSelected) Honeydew else Brown,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }
}
