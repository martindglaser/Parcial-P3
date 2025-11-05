package com.example.parcialtp3.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.Brown
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.ThemeAwareColors

@Composable
fun BottomNavBar(navController: NavHostController, current: String) {
    val themeColors = ThemeAwareColors.getColors()

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = themeColors.navBarColor,
        shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
        tonalElevation = 3.dp,
    ) {
        NavigationBar(
            containerColor = Color.Transparent,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 0.dp)
        ) {
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
                        val density = LocalDensity.current
                        val boxSizeDp = 57.dp
                        val boxSizePx = with(density) { boxSizeDp.toPx().toInt() }

                        Box(
                            modifier = Modifier
                                .layout { measurable, _ ->
                                    val placeable = measurable.measure(
                                        androidx.compose.ui.unit.Constraints.fixed(boxSizePx, boxSizePx)
                                    )
                                    layout(boxSizePx, boxSizePx) {
                                        placeable.placeRelative(0, 0)
                                    }
                                }
                                .background(
                                    color = if (isSelected) CaribbeanGreen else Color.Transparent,
                                    shape = RoundedCornerShape(14.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            BottomNavIcon(
                                iconResId = iconRes,
                                contentDescription = route
                            )
                        }
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
                    ),
                    modifier = Modifier.padding(vertical = 0.dp)
                )
            }
        }
    }
}
