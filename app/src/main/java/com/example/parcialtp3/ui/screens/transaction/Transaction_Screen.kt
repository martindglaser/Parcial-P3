package com.example.parcialtp3.ui.screens.transaction

import androidx.compose.ui.graphics.Color

data class Transaction(
    val iconRes: Int,
    val title: String,
    val subtitle: String,
    val middleText: String,
    val value: String,
    val valueColor: Color
)
