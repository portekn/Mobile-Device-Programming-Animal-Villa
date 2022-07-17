package app.DTO

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * The prompt object to store data.
 * @param PromptText the text to display from the prompt.
 * @param Energy the amount of energy the prompt will require or give.
 * @param Money the amount of money the prompt will require or give.
 * @param Status the status of the prompt.
 * @param Left if the prompt was swiped left
 * @param Right if the prompt was swiped right
 * @constructor creates a prompt with the given parameters.
 */
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