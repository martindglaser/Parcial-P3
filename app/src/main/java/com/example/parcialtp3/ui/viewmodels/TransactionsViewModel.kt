package com.example.parcialtp3.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcialtp3.data.remote.TransactionsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TransactionsViewModel : ViewModel() {

    private val repository = TransactionsRepository()

    private val _transactionsByMonth = MutableStateFlow<Map<String, List<Map<String, Any>>>>(emptyMap())
    val transactionsByMonth: StateFlow<Map<String, List<Map<String, Any>>>> = _transactionsByMonth

    fun loadTransactions(typeFilter: String?) {
        viewModelScope.launch {
            try {
                val result = if (typeFilter.isNullOrBlank()) {
                    repository.getTransactionsGroupedByMonth() // sin filtro → todas
                } else {
                    repository.getTransactionsGroupedByMonth(typeFilter)
                }

                _transactionsByMonth.value = result


                _transactionsByMonth.value = repository.getTransactionsGroupedByMonth(typeFilter)
            } catch (e: Exception) {
                e.printStackTrace()
                _transactionsByMonth.value = emptyMap()
            }
        }
    }
}