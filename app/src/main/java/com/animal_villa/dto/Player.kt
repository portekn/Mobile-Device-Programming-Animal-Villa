package com.animal_villa.dto

import androidx.room.Entity

@Entity
class Player {
    var Status:Int=100;
    var Money=0;
    var Energy=30;
    var CurrentLocation=0;
}