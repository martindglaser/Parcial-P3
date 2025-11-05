package com.example.parcialtp3.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcialtp3.data.remote.AuthRepository
import com.example.parcialtp3.di.Providers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WelcomeViewModel(
    private val repo: AuthRepository = Providers.authRepository
) : ViewModel() {

    private val _token = MutableStateFlow<String?>(null)
    val token = _token.asStateFlow()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val resp = repo.login(username, password)
                _token.value = resp.token
            } catch (e: Exception) {
                _token.value = null
            }
        }
    }
}