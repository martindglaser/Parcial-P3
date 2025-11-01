package com.example.parcialtp3.ui.screens.categories

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.CategoryGridItem
import com.example.parcialtp3.ui.components.FinanceSummaryBlock
import com.example.parcialtp3.ui.components.HeaderBar

data class CategoryUi(
    val id: String,
    val title: String,
    val iconRes: Int,
    val isPrimary: Boolean = false
)

@Composable
fun CategoriesScreen(
    onBack: () -> Unit = {},
    onCategoryClick: (String) -> Unit = {}
) {
    val primaryColor = Color(0xFF006BFF)
    val secondaryColor = Color(0xFF87C8FF)

    val categories = listOf(
        CategoryUi("food", "Food", R.drawable.vector_food, true),
        CategoryUi("transport", "Transport", R.drawable.vector_transport),
        CategoryUi("medicine", "Medicine", R.drawable.vector_medicine),
        CategoryUi("groceries", "Groceries", R.drawable.vector_groceries),
        CategoryUi("rent", "Rent", R.drawable.vector_rent),
        CategoryUi("gifts", "Gifts", R.drawable.vector_gift),
        CategoryUi("savings", "Savings", R.drawable.vector_gift),
        CategoryUi("entertainment", "Entertainment", R.drawable.vector_enter),
        CategoryUi("new_category", "More", R.drawable.vector_more)
    )

    BackgroundScaffold(
        headerHeight = 290.dp,
        headerColor = CaribbeanGreen,
        panelColor = Honeydew,
        headerContent = {
            Column {
                HeaderBar(
                    title = "Categories",
                    onBackClick = onBack,
                    onNotificationClick = { /* ... */ }
                )
                Spacer(modifier = Modifier.height(12.dp))
                FinanceSummaryBlock()
            }
        },
        panelContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 18.dp)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 32.dp)
                ) {
                    items(categories) { item ->
                        CategoryGridItem(
                            title = item.title,
                            iconRes = item.iconRes,
                            backgroundColor = if (item.isPrimary) primaryColor else secondaryColor,
                            onClick = { onCategoryClick(item.id) }
                        )
                    }
                }
            }
        }
    )
}