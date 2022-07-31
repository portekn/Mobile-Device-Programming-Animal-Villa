package app.DTO

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Prompt(
    var PromptText: String,
    var LeftOption: String,
    var LeftEnergy: Int,
    var LeftMoney: Int,
    var LeftStatus: Int,
    var RightOption: String,
    var RightEnergy: Int,
    var RightMoney: Int,
    var RightStatus: Int,
    var NextLeft: Int,
    var NextRight: Int,
    @PrimaryKey var id : Int = 0,
    var NextDay: Boolean
)