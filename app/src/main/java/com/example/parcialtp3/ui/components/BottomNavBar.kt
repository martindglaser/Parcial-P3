package com.example.parcialtp3.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.VerdeCaribeno
import com.example.parcialtp3.Brown

@Composable
fun BottomNavBar(
    navController: NavHostController,
    current: String
) {
    NavigationBar(containerColor = VerdeCaribeno) {

        val selectedColor = Brown
        val unselectedColor = Color.White

        // HOME
        NavigationBarItem(
            icon = {
                BottomNavIcon(
                    iconResId = R.drawable.ic_home,
                    contentDescription = "Home",
                    isSelected = current == "transactions",
                    selectedColor = selectedColor,
                    unselectedColor = unselectedColor
                )
            },
            selected = current == "transactions",
            onClick = { navController.navigate("transactions") },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                unselectedIconColor = unselectedColor,
                indicatorColor = Color.Transparent
            )
        )

        // ANALYSIS
        NavigationBarItem(
            icon = {
                BottomNavIcon(
                    iconResId = R.drawable.ic_analysis,
                    contentDescription = "Analysis",
                    isSelected = current == "analysis",
                    selectedColor = selectedColor,
                    unselectedColor = unselectedColor
                )
            },
            selected = current == "analysis",
            onClick = { navController.navigate("analysis") },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                unselectedIconColor = unselectedColor,
                indicatorColor = Color.Transparent
            )
        )

        // TRANSACTION
        NavigationBarItem(
            icon = {
                BottomNavIcon(
                    iconResId = R.drawable.ic_transaction,
                    contentDescription = "Transaction",
                    isSelected = current == "favourites",
                    selectedColor = selectedColor,
                    unselectedColor = unselectedColor
                )
            },
            selected = current == "favourites",
            onClick = { navController.navigate("favourites") },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                unselectedIconColor = unselectedColor,
                indicatorColor = Color.Transparent
            )
        )

        // CATEGORY
        NavigationBarItem(
            icon = {
                BottomNavIcon(
                    iconResId = R.drawable.ic_category,
                    contentDescription = "Category",
                    isSelected = current == "category",
                    selectedColor = selectedColor,
                    unselectedColor = unselectedColor
                )
            },
            selected = current == "category",
            onClick = { navController.navigate("category") },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                unselectedIconColor = unselectedColor,
                indicatorColor = Color.Transparent
            )
        )

        // PROFILE
        NavigationBarItem(
            icon = {
                BottomNavIcon(
                    iconResId = R.drawable.ic_profile,
                    contentDescription = "Profile",
                    isSelected = current == "profile",
                    selectedColor = selectedColor,
                    unselectedColor = unselectedColor
                )
            },
            selected = current == "profile",
            onClick = { navController.navigate("profile") },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                unselectedIconColor = unselectedColor,
                indicatorColor = Color.Transparent
            )
        )
    }
}
