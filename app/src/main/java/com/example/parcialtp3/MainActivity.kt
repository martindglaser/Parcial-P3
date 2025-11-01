package com.example.parcialtp3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.parcialtp3.ui.components.BottomNavIcon
import com.example.parcialtp3.ui.screens.launch.LaunchScreen
import com.example.parcialtp3.ui.screens.launch.SplashScreen
import com.example.parcialtp3.ui.screens.loginSignUp.WelcomeScreen
import kotlinx.coroutines.launch

val VerdeCaribeno = Color(0xFF00C49F)
val Brown = Color(0xFF6D4C41)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppWithDrawer()
        }
    }
}

/* ---------------- ESTRUCTURA CON DRAWER ---------------- */
@Composable
fun AppWithDrawer() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navController = navController, drawerState = drawerState)
        }
    ) {
        MainNavHost(navController = navController, drawerState = drawerState)
    }
}

/* ---------------- CONTENIDO DEL DRAWER ---------------- */
@Composable
fun DrawerContent(navController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    ModalDrawerSheet {
        Text(
            "Menu",
            modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        NavigationDrawerItem(
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text("Shop") },
            selected = false,
            onClick = {
                navController.navigate("shopList")
                scope.launch { drawerState.close() }
            }
        )
        NavigationDrawerItem(
            icon = { Icon(Icons.Default.Favorite, contentDescription = null) },
            label = { Text("Favourites") },
            selected = false,
            onClick = {
                navController.navigate("favourites")
                scope.launch { drawerState.close() }
            }
        )
        NavigationDrawerItem(
            icon = { Icon(Icons.Default.Person, contentDescription = null) },
            label = { Text("Profile") },
            selected = false,
            onClick = {
                navController.navigate("profile")
                scope.launch { drawerState.close() }
            }
        )
        NavigationDrawerItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = null) },
            label = { Text("Settings") },
            selected = false,
            onClick = {
                navController.navigate("settings")
                scope.launch { drawerState.close() }
            }
        )
    }
}

/* ---------------- NAVHOST PRINCIPAL ---------------- */
@Composable
fun MainNavHost(navController: NavHostController, drawerState: DrawerState) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") { SplashScreen(navController) }
        composable("launch") { LaunchScreen(navController) }
        composable("welcome") { WelcomeScreen(navController) }

        composable("shopList") { Transactions(navController, drawerState) }
        composable("favourites") { FavouritesScreen(navController, drawerState) }
        composable("profile") { ProfileScreen(navController, drawerState) }
        composable("settings") { SettingsScreen(navController, drawerState) }
    }
}

/* ---------------- TOP BAR ---------------- */
@Composable
fun CustomTopBar(title: String, onMenuClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(VerdeCaribeno)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onMenuClick) {
            Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.Black)
        }
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.Black)
    }
}

/* ---------------- BOTTOM NAV ---------------- */
@Composable
fun BottomNav(navController: NavHostController, current: String) {
    NavigationBar(containerColor = VerdeCaribeno) {
        val selectedColor = Brown
        val unselectedColor = Color.White

        NavigationBarItem(
            icon = {
                BottomNavIcon(
                    iconResId = R.drawable.ic_home,
                    contentDescription = "Home",
                    isSelected = current == "shopList",
                    selectedColor = selectedColor,
                    unselectedColor = unselectedColor
                )
            },
            label = null,
            selected = current == "shopList",
            onClick = { navController.navigate("shopList") },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                unselectedIconColor = unselectedColor,
                indicatorColor = Color.Transparent
            )
        )

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
            label = null,
            selected = current == "analysis",
            onClick = { navController.navigate("analysis") },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                unselectedIconColor = unselectedColor,
                indicatorColor = Color.Transparent
            )
        )

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
            label = null,
            selected = current == "favourites",
            onClick = { navController.navigate("favourites") },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                unselectedIconColor = unselectedColor,
                indicatorColor = Color.Transparent
            )
        )

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
            label = null,
            selected = current == "category",
            onClick = { navController.navigate("category") },
            alwaysShowLabel = false,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                unselectedIconColor = unselectedColor,
                indicatorColor = Color.Transparent
            )
        )

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
            label = null,
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

/* ---------------- PANTALLAS DE EJEMPLO ---------------- */

@Composable
fun Transactions(navController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = { CustomTopBar("Transactions") { scope.launch { drawerState.open() } } },
        bottomBar = { BottomNav(navController, current = "shopList") },
        containerColor = VerdeCaribeno
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Pantalla Transactions")
        }
    }
}

@Composable
fun FavouritesScreen(navController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = { CustomTopBar("Favourites") { scope.launch { drawerState.open() } } },
        bottomBar = { BottomNav(navController, current = "favourites") },
        containerColor = VerdeCaribeno
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Pantalla Favourites")
        }
    }
}

@Composable
fun ProfileScreen(navController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = { CustomTopBar("Profile") { scope.launch { drawerState.open() } } },
        bottomBar = { BottomNav(navController, current = "profile") },
        containerColor = VerdeCaribeno
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Pantalla Profile")
        }
    }
}

@Composable
fun SettingsScreen(navController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = { CustomTopBar("Settings") { scope.launch { drawerState.open() } } },
        bottomBar = { BottomNav(navController, current = "settings") },
        containerColor = VerdeCaribeno
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Pantalla Settings")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppWithDrawer()
}
