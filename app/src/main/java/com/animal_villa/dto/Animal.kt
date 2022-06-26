package com.animal_villa.dto

data class Animal(var name : String, var reputation : Int) {
    override fun toString(): String {
        return "$name $reputation"
    }
}