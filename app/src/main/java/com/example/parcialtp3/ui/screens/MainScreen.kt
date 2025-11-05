package com.example.parcialtp3.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

data class NavItem(val label: String, val icon: ImageVector, val route: String)

@Composable
fun MainScreen(navController: NavController) {
    val navItems = listOf(
        NavItem("Home", Icons.Default.Home, "HomeScreen"),
        NavItem("Favorites", Icons.Default.Favorite, "favorites"),
        NavItem("Add", Icons.Default.Add, "add"),
        NavItem("Profile", Icons.Default.Person, "profile"),
        NavItem("Settings", Icons.Default.Settings, "settings")
    )
    var selectedItem by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                navItems.forEachIndexed { index, navItem ->
                    IconButton(onClick = { selectedItem = index }) {
                        Icon(navItem.icon, contentDescription = navItem.label)
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            // Content of the selected screen
            Text(text = "Screen ${navItems[selectedItem].label}")
        }
    }
}