package com.animal_villa.dto
import androidx.room.Entity

@Entity
class Character {
    lateinit var name:String
    var age:Int=0;
    lateinit var job:String
    lateinit var statusValues:MutableList<Int> //TODO dont know what a status value is so I made it an int

}