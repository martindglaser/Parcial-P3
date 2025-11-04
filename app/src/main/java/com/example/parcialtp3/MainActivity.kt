package com.example.parcialtp3

import CategoriesScreen
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
import com.example.parcialtp3.ui.screens.categories.entertainment.A_Entertainment_Screen
import com.example.parcialtp3.ui.screens.categories.entertainment.B_Entertainment
import com.example.parcialtp3.ui.screens.categories.food.FoodAddExpenseScreen
import com.example.parcialtp3.ui.screens.accountBalance.AccountBalanceScreen
import com.example.parcialtp3.ui.screens.categories.food.FoodScreen
import com.example.parcialtp3.ui.screens.categories.gifts.GiftsScreen
import com.example.parcialtp3.ui.screens.categories.gifts.Gifts_Add_Expenses_Screen
import com.example.parcialtp3.ui.screens.categories.groceries.GroceriesAddExpenseScreen
import com.example.parcialtp3.ui.screens.categories.groceries.GroceriesScreen
import com.example.parcialtp3.ui.screens.categories.medicine.A_Medicine_Screen
import com.example.parcialtp3.ui.screens.categories.medicine.Medicine_Add_Expenses_Screen
import com.example.parcialtp3.ui.screens.categories.rent.RentScreen
import com.example.parcialtp3.ui.screens.categories.saving.CarScreen
import com.example.parcialtp3.ui.screens.categories.saving.Car_Expenses_Screen
import com.example.parcialtp3.ui.screens.categories.saving.NewHouseScreen
import com.example.parcialtp3.ui.screens.categories.saving.New_House_Add_Expenses_Screen
import com.example.parcialtp3.ui.screens.categories.saving.SavingsScreen
import com.example.parcialtp3.ui.screens.categories.saving.TravelAddExpenseScreen
import com.example.parcialtp3.ui.screens.categories.saving.TravelScreen
import com.example.parcialtp3.ui.screens.categories.saving.WeddingScreen
import com.example.parcialtp3.ui.screens.categories.saving.Wedding_Expense_Screen
import com.example.parcialtp3.ui.screens.categories.transport.TransportAddExpenseScreen
import com.example.parcialtp3.ui.screens.categories.transport.TransportScreen
import com.example.parcialtp3.ui.screens.home.HomeScreen
import com.example.parcialtp3.ui.screens.launch.LaunchScreen
import com.example.parcialtp3.ui.screens.launch.SplashScreen
import com.example.parcialtp3.ui.screens.loginSignUp.CreateAccountScreen
import com.example.parcialtp3.ui.screens.loginSignUp.ForgotPasswordScreen
import com.example.parcialtp3.ui.screens.loginSignUp.NewPasswordScreen
import com.example.parcialtp3.ui.screens.loginSignUp.SecurityPinScreen
import com.example.parcialtp3.ui.screens.loginSignUp.WelcomeScreen
import com.example.parcialtp3.ui.screens.notifications.NotificationScreen
import com.example.parcialtp3.ui.screens.onBoarding.OnBoardingPagerScreen
import com.example.parcialtp3.ui.screens.profile.Edit_Profile_Screen
import com.example.parcialtp3.ui.screens.profile.Profile_Screen
import com.example.parcialtp3.ui.screens.profile.security.A_Security_Screen
import com.example.parcialtp3.ui.screens.transaction.TransactionScreen
import com.example.parcialtp3.ui.screens.transactions.TransactionsExpenseScreen
import com.example.parcialtp3.ui.screens.transactions.TransactionsIncomeScreen
import com.example.parcialtp3.ui.screens.transactions.Transactions_Screen
import com.example.parcialtp3.ui.screens.profile.security.B_Change_Pin_Screen
import com.example.parcialtp3.ui.screens.profile.security.D_Fingerprint_Screen
import com.example.parcialtp3.ui.screens.profile.security.H_Terms_And_Conditions_Screen
import com.example.parcialtp3.ui.screens.profile.security.C_Change_Pin_Success_Screen
import com.example.parcialtp3.ui.screens.profile.security.E_Fingerprint_Screen
import com.example.parcialtp3.ui.screens.profile.security.F_Fingerprint_Add_Screen
import com.example.parcialtp3.ui.screens.profile.security.G_Fingerprint_Eliminate_Screen
import com.example.parcialtp3.ui.screens.profile.security.G_Fingerprint_Screen
import com.example.parcialtp3.ui.screens.profile.setting.A_Settings_Screen
import com.example.parcialtp3.ui.screens.profile.setting.B_Notification_Settings_Screen
import com.example.parcialtp3.ui.screens.profile.setting.C_Password_Settings_Screen
import com.example.parcialtp3.ui.screens.profile.setting.D_Password_Settings_Screen
import com.example.parcialtp3.ui.screens.profile.setting.E_Delete_Account_Screen
import com.example.parcialtp3.ui.screens.profile.help.help_center.A_B_Help_Center_Screen
import com.example.parcialtp3.ui.screens.profile.help.online_support.A_Online_Support_Screen
import com.example.parcialtp3.ui.screens.profile.help.online_support.B_Online_Support_Screen
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
        //composable("onboarding") { OnBoardingPagerScreen(navController) }
        composable("OnBoardingPagerScreen?next={next}") { backStackEntry ->
            val next = backStackEntry.arguments?.getString("next") ?: "HomeScreen"
            OnBoardingPagerScreen(navController = navController, nextRoute = next)
        }

        composable("HomeScreen") { HomeScreen(navController) }
        composable("notifications") { NotificationScreen(navController) }
        composable("account_balance") { AccountBalanceScreen(navController) }
        //composable("b_launch") { LaunchScreen(navController) }

        composable("edit_profile") { Edit_Profile_Screen(navController) }


        composable("Tranasction_Screen") { TransactionScreen(navController) }
        composable("Tranasctions_Screen") { Transactions_Screen(navController) }
        composable("Income_Screen") { TransactionsIncomeScreen(navController) }
        composable("Expense_Screen") { TransactionsExpenseScreen(navController) }


//cat
        composable("categories") { CategoriesScreen(navController) }
        composable("food") { FoodScreen(navController) }
        composable("food/addExpense") { FoodAddExpenseScreen(navController) }
        composable("transport") { TransportScreen(navController) }
        composable("transport/addExpense") { TransportAddExpenseScreen(navController) }
        composable("medicine") { A_Medicine_Screen(navController) }
        composable("medicine/addExpense") { Medicine_Add_Expenses_Screen(navController) }
        composable("groceries") { GroceriesScreen(navController) }
        composable("groceries/addExpense") { GroceriesAddExpenseScreen(navController) }
        composable("rent") { RentScreen(navController) }
        composable("rent/addExpense") { GroceriesAddExpenseScreen(navController) }
        composable("gifts") { GiftsScreen(navController) }
        composable("gifts/addExpense") { Gifts_Add_Expenses_Screen(navController) }
        composable("entertainment") { A_Entertainment_Screen(navController) }
        composable("entertainment/addExpense") { B_Entertainment(navController) }

//sav

        composable("savings") { SavingsScreen(navController) }
        composable("travel") { TravelScreen(navController) }
        composable("savings/addExpense") { TravelAddExpenseScreen(navController) }
        composable("newHouse") { NewHouseScreen(navController) }
        composable("newHouse/addExpense") { New_House_Add_Expenses_Screen(navController) }
        composable("car") { CarScreen(navController) }
        composable("car/carExpense") { Car_Expenses_Screen(navController) }
        composable("wedding") { WeddingScreen(navController) }
        composable("wedding/addExpense") { Wedding_Expense_Screen(navController) }

// Rutas para agregar ahorros
        composable("travel/addSavings") { TravelAddExpenseScreen(navController) }
        composable("newHouse/addSavings") { New_House_Add_Expenses_Screen(navController) }
        composable("car/addSavings") { Car_Expenses_Screen(navController) }
        composable("wedding/addSavings") { Wedding_Expense_Screen(navController) }



        composable("security") { A_Security_Screen(navController, onChangePin = { navController.navigate("change_pin") },  onFingerprint = { navController.navigate("fingerprints") }, onTerms = { navController.navigate("termsAndConditions") }) }
        composable("shopList") { Transactions(navController, drawerState) }
        composable("favourites") { FavouritesScreen(navController, drawerState) }
        composable("profile") { Profile_Screen(navController)}
        composable("settings") { A_Settings_Screen(navController) }

        composable("WelcomeScreen") { WelcomeScreen(navController = navController) }
        composable("CreateAccountScreen") { CreateAccountScreen(navController = navController) }
        composable("SecurityPinScreen") { SecurityPinScreen(navController = navController) }
        composable("ForgotPasswordScreen") { ForgotPasswordScreen(navController) }
        composable("NewPasswordScreen") { NewPasswordScreen(navController) }

        composable("change_pin") { B_Change_Pin_Screen(navController, onConfirm = { navController.navigate("change_pin_success") }) }
        composable("fingerprints") { D_Fingerprint_Screen(navController, onTapExisting = {navController.navigate("fingerprint")}, onAddFingerprint = {navController.navigate("fingerprint_add")}) }
        composable("termsAndConditions") { H_Terms_And_Conditions_Screen(navController, onAccept = { navController.navigate("security") }) }
        composable("change_pin_success") { C_Change_Pin_Success_Screen() }
        composable("fingerprint_add") { F_Fingerprint_Add_Screen(navController, onUseTouchId = {navController.navigate("fingerprint_add_success")}) }
        composable("fingerprint") { E_Fingerprint_Screen(navController, onDelete = { navController.navigate("fingerprint_eliminated_success") }) }
        composable("fingerprint_eliminated_success") { G_Fingerprint_Eliminate_Screen() }
        composable("fingerprint_add_success") { G_Fingerprint_Screen() }

        composable("settings") {A_Settings_Screen(navController, onNotification= {navController.navigate("notification_settings")}, onPassword = {navController.navigate("password_settings")}, onDeleteAccount = {navController.navigate("delete_account")}) }
        composable("notification_settings") {B_Notification_Settings_Screen(navController)}
        composable("password_settings") {C_Password_Settings_Screen(navController, onChangePassword = {navController.navigate("password_change_success")}) }
        composable("delete_account") {E_Delete_Account_Screen(navController)}
        composable("password_change_success") {D_Password_Settings_Screen()}

        composable("help_center") {A_B_Help_Center_Screen(navController, onClickCustomService = {navController.navigate("online_support_chats")})}
        composable("online_support_chats") { A_Online_Support_Screen(navController, onStartNewChat = {navController.navigate("online_support_assistant")}) }
        composable("online_support_assistant") { B_Online_Support_Screen(navController) }
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