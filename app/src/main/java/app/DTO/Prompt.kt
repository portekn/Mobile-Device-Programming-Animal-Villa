package app.DTO

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Prompt(
    var PromptText: String,
    var Energy: Int,
    var Money: Int,
    var Status: Int,
    var Left: Int,
    var Right: Int,
    @PrimaryKey var id : Int = 0
)