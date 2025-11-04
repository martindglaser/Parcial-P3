package com.example.parcialtp3.data.repository

import com.example.parcialtp3.data.local.ThemeDao
import com.example.parcialtp3.data.local.ThemePreference

class ThemeRepository(private val dao: ThemeDao) {

    suspend fun getTheme(): Boolean {
        return dao.getTheme()?.darkModeEnabled ?: false
    }

    suspend fun saveTheme(enabled: Boolean) {
        dao.saveTheme(ThemePreference(darkModeEnabled = enabled))
    }
}