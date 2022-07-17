package app.DTO


/**
 * The player object to store data.
 * @param Energy the amount of energy the player has.
 * @param Money the amount of money the player has.
 * @param Status the status of the player.
 * @param Day the day the player is currently on.
 * @constructor creates a prompt with the given parameters.
 */
data class Player(
    var Energy: Int,
    var Money: Int,
    var Status: Int,
    var Day: Int
) {
}