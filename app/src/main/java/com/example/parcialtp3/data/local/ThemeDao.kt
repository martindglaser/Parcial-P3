package com.example.parcialtp3.data.local

import androidx.room.*

@Dao
interface ThemeDao {

    @Query("SELECT * FROM theme_preferences WHERE id = 1 LIMIT 1")
    suspend fun getTheme(): ThemePreference?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTheme(theme: ThemePreference)
}
