package com.example.parcialtp3

import CategoriesScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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

val VerdeCaribeno = Color(0xFF00C49F)
val Brown = Color(0xFF6D4C41)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    MainNavHost(navController = rememberNavController())
}


/* ---------------- NAVHOST PRINCIPAL ---------------- */
@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "HomeScreen"
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