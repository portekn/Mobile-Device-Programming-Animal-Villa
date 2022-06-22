/**
 * Data object that holds the player's data.
 *
 * @property status The status of the player.
 * @property money how much money the player currently has.
 * @property energy how much energy the player currently has.
 * @property playerStorage the player's storage
 */
data class Player(var status : String, var money : Int, var energy : Int, var playerStorage : Int) {

    var playerEffect = Array<String>()

    /**
     * This returns the player's current status as a string.
     *
     * @return the status of the player
     */
    override fun toString(): String {
        return status
    }

    /**
     * Instantiates the player object for the game.
     */
    fun GeneratePlayer(){
        return "Not Implemented"
    }

    /**
     * Reset the player's stats.
     */
    fun ResetPlayer(){
        return "Not Implemented"
    }
}