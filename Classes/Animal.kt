//Class for animal characters to inherit.

 public class Animal {

    //Unique character/family name
    val name;
    //Tracks the animals frienship with the player
    val playerFriendship;
    //Stores the path to the file with that characters prompts and stats.
    val promptStorage;


    fun GenerateCharacter(name: String, playerFriendship: Int, promptStorage: String) void {
        //Set up the character and generate the data files

    }

    fun AddFriendship(increase: Int){
        //Increase characters frindship with player
       // Update character data file
    }

    fun RemoveFriendship(decrease: Int){
        //Decrease characters frindship with player
       // Update character data file
    }

    fun AddPlayerEffect(effect: String){
        //Adds an effect to the characters effect array.
    }

    fun GetPrompt(){
       //Gets prompt for character, this will probably be a complex method with nesting ifs

    }

    fun ResetAnimalStats(){
       //For use when restarting the game so it does not have to regenerrate the files.
    }

}