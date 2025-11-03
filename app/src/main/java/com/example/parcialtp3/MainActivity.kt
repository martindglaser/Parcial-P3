package com.example.parcialtp3

import CategoriesScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.OceanBlue
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BottomNavIcon

import com.example.parcialtp3.ui.poppinsFamily
import com.example.parcialtp3.ui.screens.categories.entertainment.A_Entertainment_Screen
import com.example.parcialtp3.ui.screens.categories.food.FoodScreen
import com.example.parcialtp3.ui.screens.categories.gifts.GiftsScreen
import com.example.parcialtp3.ui.screens.categories.groceries.GroceriesScreen


import com.example.parcialtp3.ui.screens.categories.medicine.A_Medicine_Screen

import com.example.parcialtp3.ui.screens.categories.rent.RentScreen
import com.example.parcialtp3.ui.screens.categories.saving.CarScreen
import com.example.parcialtp3.ui.screens.categories.saving.NewHouseScreen
import com.example.parcialtp3.ui.screens.categories.saving.SavingsScreen
import com.example.parcialtp3.ui.screens.categories.saving.TravelScreen
import com.example.parcialtp3.ui.screens.categories.saving.WeddingScreen
import com.example.parcialtp3.ui.screens.categories.transport.TransportScreen


import kotlinx.coroutines.launch

val VerdeCaribeno = Color(0xFF00C49F)
val Brown = Color(0xFF6D4C41)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Parcialtp3Theme { // Se comenta temporalmente para evitar el error de compilación.
                //AppWithDrawer()
            CategoriesScreen()     // A_Medicine_Screen()   TransportScreen ()  FoodAddExpenseScreen() FoodScreen() CategoriesScreen () SavingsScreen()  TravelScreen() TravelAddExpenseScreen ()
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
    NavHost(navController = navController, startDestination = "shopList") {
        composable("shopList") { Transactions(navController, drawerState) }
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
    NavigationBar(containerColor = VerdeCaribeno) {

        val selectedColor = Brown
        val unselectedColor = Color.White

        // HOME
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
                indicatorColor = Color.Transparent // elimina el fondo circular
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


/* ---------------- PANTALLAS ---------------- */

@Composable
fun TarjetaBalance(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    text1: String,
    text2: String
){
    Column(modifier.padding(horizontal = 8.dp, vertical = 16.dp)) { // Ajustamos el padding
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = backgroundColor) // Usamos el color de fondo
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = text1, // Usamos el primer texto
                    color = Void, // Usamos su color
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    fontFamily = poppinsFamily
                )
                Text(
                    text = text2, // Usamos el segundo texto
                    color = Void, // Usamos su color
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    fontFamily = poppinsFamily
                )
            }
        }
    }
}

@Composable
fun TarjetasIncomeExpense(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    imageResId: Int,
    text1: String,
    text2: String,
    text1Color: Color = MaterialTheme.colorScheme.onSurface,
    text2Color: Color = Color.Gray
) {
    Column(modifier.padding(horizontal = 8.dp, vertical = 8.dp)) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = backgroundColor)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = text1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = text1,
                    color = text1Color,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    fontFamily = poppinsFamily
                )
                Text(
                    text = text2,
                    color = text2Color,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    fontFamily = poppinsFamily
                )
            }
        }
    }
}

// CORRECCIÓN: El modifier se aplica al Row, no se usa weight aquí.
@Composable
fun Cabecera(modifier: Modifier = Modifier) {
    Column(Modifier.padding(15.dp, 0.dp)){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TarjetaBalance(
            backgroundColor = Honeydew,
            text1 = "Total Balance",
            text2 = "7,783.00"
        )
    }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Usamos Box con weight para que cada tarjeta ocupe la mitad del espacio de la fila
        Box(modifier = Modifier.weight(1f)) {
            TarjetasIncomeExpense(
                backgroundColor = Color.White,
                imageResId = R.drawable.group_395,
                text1 = "Income",
                text2 = "4,120.00",
                text1Color = Color.Black,
                text2Color = Color.Black
            )
        }
        Box(modifier = Modifier.weight(1f)) {
            TarjetasIncomeExpense(
                backgroundColor = Color.White,
                imageResId = R.drawable.group_396,
                text1 = "Expense",
                text2 = "1,187.40",
                text1Color = Color.Black,
                text2Color = OceanBlue
            )
        }
    }
}
}

@Composable
fun Transactions(
    navController: NavHostController,
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = { CustomTopBar("Shop list") { scope.launch { drawerState.open() } } },
        bottomBar = { BottomNav(navController, current = "shopList") },
        containerColor = VerdeCaribeno
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            // Cabecera con las dos tarjetas
            Cabecera()

            // CORRECCIÓN: Spacer con weight para empujar los botones hacia abajo
            Spacer(modifier = Modifier.weight(1f))

            // Fila de botones en la parte inferior
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
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
        // Contenido de la pantalla de perfil
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Profile Screen")
        }
    }
}

@Composable
fun SettingsScreen(navController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = { CustomTopBar("Settings") { scope.launch { drawerState.open() } } },
        bottomBar = { BottomNav(navController, current = "settings") }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Settings Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    // Parcialtp3Theme {
        AppWithDrawer()
    // }
}
