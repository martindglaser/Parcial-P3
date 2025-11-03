package com.example.parcialtp3.ui.screens.categories.saving

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.CategoryGridItem
import com.example.parcialtp3.ui.components.FinanceSummaryBlock
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.PrimaryButton

data class SavingCategoryUi(
    val id: String,
    val title: String,
    val iconRes: Int,
    val isPrimary: Boolean = false
)

@Composable
fun SavingsScreen(
    navController: NavHostController
) {
    val primaryColor = Color(0xFF006BFF)
    val secondaryColor = Color(0xFF87C8FF)

    val categories = listOf(
        SavingCategoryUi("travel", "Travel", R.drawable.vector_plane, true),
        SavingCategoryUi("new_house", "New House", R.drawable.vector_newhouse),
        SavingCategoryUi("car", "Car", R.drawable.vector_car),
        SavingCategoryUi("wedding", "Wedding", R.drawable.vector_wedding),
    )

    BackgroundScaffold(
        headerHeight = 290.dp,
        headerColor = CaribbeanGreen,
        panelColor = Honeydew,
        headerContent = {
            Column {
                HeaderBar(
                    title = "Savings",
                    navController = navController
                )
                Spacer(modifier = Modifier.height(12.dp))
                FinanceSummaryBlock()
            }
        },
        panelContent = {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 18.dp)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 32.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    items(categories) { item ->
                        CategoryGridItem(
                            title = item.title,
                            iconRes = item.iconRes,
                            backgroundColor = if (item.isPrimary) primaryColor else secondaryColor,
                            onClick = { navController?.navigate(item.id) }
                        )
                    }
                }

                PrimaryButton(
                    text = "Add More",
                    onClick = { /* Lógica para añadir */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 8.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
    )
}