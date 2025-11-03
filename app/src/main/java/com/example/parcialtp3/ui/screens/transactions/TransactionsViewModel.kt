package com.example.parcialtp3.ui.screens.transactions

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TransactionsViewModel : ViewModel() {

    private val _transactionsByMonth = MutableStateFlow<Map<String, List<Map<String, Any>>>>(emptyMap())
    val transactionsByMonth: StateFlow<Map<String, List<Map<String, Any>>>> = _transactionsByMonth

    fun loadTransactions(typeFilter: String? = null) {
        val sampleData = listOf(
            mapOf("description" to "Salary", "date" to "18:27 – April 30", "subtype" to "Monthly", "amount" to "4000.00", "type" to "income"),
            mapOf("description" to "Groceries", "date" to "17:00 – April 24", "subtype" to "Pantry", "amount" to "100.00", "type" to "expense"),
            mapOf("description" to "Rent", "date" to "8:30 – April 15", "subtype" to "Rent", "amount" to "674.40", "type" to "expense")
        )

        _transactionsByMonth.value = mapOf(
            "April 2024" to sampleData
        )
    }
}
