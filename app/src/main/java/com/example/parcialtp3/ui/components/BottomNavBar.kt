package com.example.parcialtp3.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.Brown
import com.example.parcialtp3.VerdeCaribeno
import com.example.parcialtp3.ui.ThemeAwareColors

@Composable
fun BottomNavBar(navController: NavHostController, current: String) {
    val themeColors = ThemeAwareColors.getColors()
    NavigationBar(containerColor = themeColors.navBarColor) {
        val selectedColor = Brown
        val unselectedColor = Color.White

        val navItems = listOf(
            Triple("HomeScreen", R.drawable.ic_home, "Home"),
            Triple("account_balance", R.drawable.ic_analysis, "Balance"),
            Triple("Tranasctions_Screen", R.drawable.ic_transaction, "Transactions"),
            Triple("categories", R.drawable.ic_category, "Categories"),
            Triple("profile", R.drawable.ic_profile, "Profile")
        )

        navItems.forEach { (route, iconRes, _) ->
            val isSelected = current == route

            NavigationBarItem(
                icon = {
                    BottomNavIcon(
                        iconResId = iconRes,
                        contentDescription = route,
                        isSelected = isSelected,
                        selectedColor = selectedColor,
                        unselectedColor = unselectedColor
                    )
                },
                label = null,
                selected = isSelected,
                onClick = {
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = selectedColor,
                    unselectedIconColor = unselectedColor,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}