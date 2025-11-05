package com.example.parcialtp3.ui.screens.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcialtp3.data.local.AppDatabase
import com.example.parcialtp3.data.repository.ThemeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThemeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ThemeRepository
    private val _darkThemeEnabled = MutableStateFlow(false)
    val darkThemeEnabled: StateFlow<Boolean> = _darkThemeEnabled

    init {
        val dao = AppDatabase.getDatabase(application).themeDao()
        repository = ThemeRepository(dao)
        loadTheme()
    }

    private fun loadTheme() {
        viewModelScope.launch {
            _darkThemeEnabled.value = repository.getTheme()
        }
    }

    fun toggleTheme(enabled: Boolean) {
        viewModelScope.launch {
            repository.saveTheme(enabled)
            _darkThemeEnabled.value = enabled
        }
    }
}
