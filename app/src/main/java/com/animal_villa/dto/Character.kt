package com.animal_villa.dto

data class Character (val characterName: String, val characterFamily: String, var characterJob: String,var characterId: Int){
    override fun toString(): String {
        return characterName.plus(" ").plus(characterJob)
    }
}