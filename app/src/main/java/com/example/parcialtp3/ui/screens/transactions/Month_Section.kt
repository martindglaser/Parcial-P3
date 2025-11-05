package com.example.parcialtp3.ui.screens.transactions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcialtp3.ui.components.Transaction

@Composable
fun MonthSection(monthName: String, transactions: List<Transaction>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = monthName,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        for (transaction in transactions) {
            Text(text = "${transaction.title} - ${transaction.value}")
        }
    }
}
