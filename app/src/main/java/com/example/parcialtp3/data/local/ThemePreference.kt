package com.example.parcialtp3.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "theme_preferences")
data class ThemePreference(
    @PrimaryKey val id: Int = 1,  // solo una fila
    val darkModeEnabled: Boolean
)
