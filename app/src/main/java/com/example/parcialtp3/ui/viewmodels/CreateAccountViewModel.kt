package com.example.parcialtp3.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcialtp3.data.remote.AuthRepository
import com.example.parcialtp3.data.remote.model.CreateAccountResponse
import com.example.parcialtp3.di.Providers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CreateAccountViewModel(
    private val repo: AuthRepository = Providers.authRepository
) : ViewModel() {

    private val _lastUser = MutableStateFlow<CreateAccountResponse?>(null)
    val lastUser = _lastUser.asStateFlow()

    fun createAccount(fullName: String, email: String, phone: String, password: String) {
        viewModelScope.launch {
            try {
                val resp = repo.createAccount(fullName, email, phone, password)
                _lastUser.value = resp
            } catch (e: Exception) {
                _lastUser.value = null
            }
        }
    }
}