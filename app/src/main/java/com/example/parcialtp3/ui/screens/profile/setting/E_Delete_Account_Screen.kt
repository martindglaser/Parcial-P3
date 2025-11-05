package com.example.parcialtp3.ui.screens.profile.setting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.ConfirmDeleteDialog
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.PasswordInputField

@Composable
fun E_Delete_Account_Screen(
    navController: NavHostController,
    onBack: () -> Unit = { navController.popBackStack() },
    onConfirmDelete: (password: String) -> Unit = {},
    onCancel: () -> Unit = { navController.popBackStack() }
) {
    var password by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    BackgroundScaffold(
        navController = navController,
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                title = "Delete Account",
                navController = navController,
                onBackClick = onBack
            )
        },
        panelContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(12.dp))

                Text(
                    text = "Are You Sure You Want To Delete\nYour Account?",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Void,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(16.dp))

                WarningCardLeftAligned()

                Spacer(Modifier.height(24.dp))

                Text(
                    text = "Please Enter Your Password To Confirm\nDeletion Of Your Account.",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Void,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(16.dp))

                PasswordInputField(
                    label = "",
                    value = password,
                    onValueChange = { password = it }
                )

                Spacer(Modifier.height(24.dp))

                // Abre modal de confirmación
                Button(
                    onClick = { showDialog = true },
                    enabled = password.isNotEmpty(),
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CaribbeanGreen,
                        contentColor = Void
                    )
                ) {
                    Text("Yes, Delete Account", style = MaterialTheme.typography.bodyLarge)
                }

                Spacer(Modifier.height(12.dp))

                Button(
                    onClick = onCancel,
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LightGreen,
                        contentColor = Void
                    )
                ) {
                    Text("Cancel", style = MaterialTheme.typography.bodyLarge)
                }

                Spacer(Modifier.height(24.dp))
            }
        }
    )

    // Modal
    ConfirmDeleteDialog(
        visible = showDialog,
        onConfirm = {
            showDialog = false
            onConfirmDelete(password)
        },
        onDismiss = { showDialog = false }
    )
}

@Composable
private fun WarningCardLeftAligned() {
    Surface(
        color = LightGreen,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "This action will permanently delete all of your data, and you will not be able to recover it. Please keep the following in mind before proceeding:",
                color = Void,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start
            )

            Spacer(Modifier.height(12.dp))

            BulletLeft("All your expenses, income and associated transactions will be eliminated.")
            Spacer(Modifier.height(8.dp))
            BulletLeft("You will not be able to access your account or any related information.")
            Spacer(Modifier.height(8.dp))
            BulletLeft("This action cannot be undone.")
        }
    }
}

@Composable
private fun BulletLeft(text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start
    ) {
        Text("•", color = Void, style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.width(8.dp))
        Text(
            text = text,
            color = Void,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Start,
            modifier = Modifier.weight(1f)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true, name = "Delete Account + Modal")
@Composable
private fun Preview_E_Delete_Account() {
    val nav = rememberNavController()
    E_Delete_Account_Screen(navController = nav)
}
