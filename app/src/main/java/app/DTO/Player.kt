package app.DTO

data class Player(
    var Energy: Int, //How much energy the player has for the day
    var Money: Int,  //How much money the player has
    var Status: Int, //The players status
    var Day: Int     //Which day the player is on
) {
}