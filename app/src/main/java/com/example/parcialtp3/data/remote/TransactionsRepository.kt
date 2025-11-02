package com.example.parcialtp3.data.remote

import com.example.parcialtp3.data.remote.model.TransactionsResponse
import java.text.SimpleDateFormat
import java.util.*

class TransactionsRepository {

    private val api = RetrofitClient.api

    suspend fun getTransactionsGroupedByMonth(typeFilter: String): Map<String, List<Map<String, Any>>> {
        val response: TransactionsResponse = api.getTransactions()

        // Filtramos según el tipo (income / expense)
        val filteredTransactions = response.transactions
            .filter { it.type == typeFilter }

        // Convertimos cada item en un mapa genérico (para tu UI)
        val allTransactions = filteredTransactions.map {
            mapOf(
                "date" to it.date,
                "description" to it.description,
                "amount" to it.amount,
                "currency" to it.currency,
                "type" to it.type,
                "subtype" to it.subtype
            )
        }

        // Ordenar por fecha descendente
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val sorted = allTransactions.sortedByDescending {
            val dateStr = it["date"]?.toString() ?: "1900-01-01"
            sdf.parse(dateStr)
        }

        // Agrupar por mes (ej: "October 2024")
        val monthFormat = SimpleDateFormat("MMMM yyyy", Locale.ENGLISH)
        val grouped = sorted.groupBy {
            try {
                val date = sdf.parse(it["date"]?.toString() ?: "")
                monthFormat.format(date ?: Date())
            } catch (e: Exception) {
                "Unknown"
            }
        }

        return grouped
    }
}
