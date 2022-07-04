package com.animal_villa.dao

import retrofit2.Call
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.animal_villa.dto.Settings



interface ISettingsDAO {
    @Query("Select * from Settings Limit 1")
    fun getSettings():Settings

    @Update
    fun updateSettings(s:Settings)

    @Insert
    fun insertSettings(s:Settings)
}