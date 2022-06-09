//Player attributes and stats to be inherited will go here.

public class Player{

    val status;
    val money;
    val energy;

    val playerStorage;
    //Stores an array of the interactions a player has had with charachters, for use in
    //determining prompts/endings
    val playerEffect = Array();

    //basic getters and add/ remove methods.

    fun GeneratePlayer(){
        //sets up the player and generates the player data file.
    }

    fun ResetPlayer(){
        //resets player stats so the game can be replayed without having to regenerate files.

    }


}