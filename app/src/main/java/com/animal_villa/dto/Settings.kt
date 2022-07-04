package com.animal_villa.dto

import androidx.room.Entity
import com.animal_villa.dao.ISettingsDAO

class Settings {
    var volume = 1
    var textSpeed = 1
    var soundEffects = true
    fun updateSettings(dao: ISettingsDAO) {
        dao.updateSettings(this)
    }
}