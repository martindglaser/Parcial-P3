package com.example.parcialtp3.data.remote.model

data class TransactionsResponse(
    val user_id: Int,
    val balance: Double,
    val income: Double,
    val expense: Double,
    val transactions: List<TransactionItem>
)

data class TransactionItem(
    val transaction_id: String,
    val date: String,
    val description: String,
    val amount: Double,
    val currency: String,
    val type: String,
    val subtype: String
)
