package com.animal_villa.dto

data class Character(var name : String, var occupation : String)    {
    override fun toString(): String {
        return "$name $occupation"
    }
}