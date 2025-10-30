package com.example.parcialtp3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3.ui.VerdeCaribeno
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = lightColorScheme()) {
                AppWithDrawer()
            }
        }
    }
}

val Brown = Color(0xFF8B4513)

/* ---------------- RAÍZ CON DRAWER ---------------- */
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
    NavHost(navController = navController, startDestination = "shopList") {
        composable("shopList") { ShopListScreen(navController, drawerState) }
        composable("detail") { DetailScreen(navController, drawerState) }
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
    NavigationBar(containerColor = Color.White) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Shop") },
            label = { Text("Product") },
            selected = current == "shopList",
            onClick = { navController.navigate("shopList") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Brown,
                selectedTextColor = Brown
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            label = { Text("Search") },
            selected = false,
            onClick = { /* futura pantalla */ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
            label = { Text("Cart") },
            selected = current == "favourites",
            onClick = { navController.navigate("favourites") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = current == "profile",
            onClick = { navController.navigate("profile") }
        )
    }
}

/* ---------------- PANTALLAS ---------------- */

@Composable
fun ShopListScreen(navController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = { CustomTopBar("Shop list") { scope.launch { drawerState.open() } } },
        bottomBar = { BottomNav(navController, current = "shopList") }
    ) { padding ->
        Column(Modifier.padding(padding)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Icon(
                        Icons.Default.ShoppingCart,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp),
                        tint = Brown
                    )
                    Spacer(Modifier.height(12.dp))
                    Text("Leather boots", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text("27,5 $", fontSize = 14.sp, color = Color.Gray)
                    Text("Great warm shoes from artificial leather. Only in our shop.")
                    Spacer(Modifier.height(12.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedButton(onClick = { navController.navigate("favourites") }) {
                            Text("Add to favourite")
                        }
                        Button(
                            onClick = { navController.navigate("detail") },
                            colors = ButtonDefaults.buttonColors(containerColor = Brown)
                        ) {
                            Text("Buy", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DetailScreen(navController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    var size by remember { mutableStateOf("") }
    var count by remember { mutableStateOf("") }

    Scaffold(
        topBar = { CustomTopBar("Leather boots") { scope.launch { drawerState.open() } } },
        bottomBar = { BottomNav(navController, current = "detail") }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(24.dp))
            Text("Select size", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            OutlinedTextField(value = size, onValueChange = { size = it }, label = { Text("Input") })
            Spacer(Modifier.height(16.dp))
            Text("Count of product", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            OutlinedTextField(value = count, onValueChange = { count = it }, label = { Text("Input") })
            Spacer(Modifier.height(24.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)
            ) {
                OutlinedButton(onClick = { navController.popBackStack() }) { Text("Back") }
                Button(
                    onClick = { /* Comprar */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Brown)
                ) { Text("Buy", color = Color.White) }
            }
        }
    }
}

@Composable
fun FavouritesScreen(navController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    val favourites = listOf("Leather boots", "Sneakers", "Yellow slippers")

    Scaffold(
        topBar = { CustomTopBar("Favourites") { scope.launch { drawerState.open() } } },
        bottomBar = { BottomNav(navController, current = "favourites") }
    ) { padding ->
        LazyColumn(Modifier.padding(padding)) {
            itemsIndexed(favourites) { index, item ->
                Card(
                    Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("${index + 1}", fontWeight = FontWeight.Bold)
                        Spacer(Modifier.width(12.dp))
                        Column {
                            Text(item, fontWeight = FontWeight.Bold)
                            Text("27,5 $", color = Color.Gray, fontSize = 12.sp)
                        }
                        Spacer(Modifier.weight(1f))
                        Button(
                            onClick = { /* Comprar */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Brown)
                        ) { Text("Buy", color = Color.White) }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(navController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    var email by remember { mutableStateOf("xxx@gmail.com") }
    var phone by remember { mutableStateOf("+5493123135") }
    var web by remember { mutableStateOf("www.google.com") }
    var password by remember { mutableStateOf("xxxxxxxxxxxx") }

    Scaffold(
        topBar = { CustomTopBar("Profile") { scope.launch { drawerState.open() } } },
        bottomBar = { BottomNav(navController, current = "profile") }
    ) { padding ->
        Column(
            Modifier.padding(padding).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(16.dp))
            Icon(
                Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            )
            Text("Martin", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text("UI UX DESIGN")
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("E-Mail Address") })
            OutlinedTextField(value = phone, onValueChange = { phone = it }, label = { Text("Phone Number") })
            OutlinedTextField(value = web, onValueChange = { web = it }, label = { Text("Web Site") })
            OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") })
        }
    }
}

@Composable
fun SettingsScreen(navController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    var notifications by remember { mutableStateOf(true) }
    var darkMode by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { CustomTopBar("Settings") { scope.launch { drawerState.open() } } },
        bottomBar = { BottomNav(navController, current = "settings") }
    ) { padding ->
        Column(Modifier.padding(padding).fillMaxSize()) {
            Text("Account Settings", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(Modifier.height(12.dp))
            Text("Edit profile")
            Text("Change password")
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Push notifications", Modifier.weight(1f))
                Switch(checked = notifications, onCheckedChange = { notifications = it })
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Dark mode", Modifier.weight(1f))
                Switch(checked = darkMode, onCheckedChange = { darkMode = it })
            }
            Spacer(Modifier.height(16.dp))
            Text("More", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text("About us")
            Text("Privacy policy")
            Text("Terms and conditions")
        }
    }
}
