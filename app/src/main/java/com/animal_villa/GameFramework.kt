package com.animal_villa

import android.widget.TextView
import com.example.main_animal_villa.R

class GameFramework(textView: TextView, private val gameRunner: GameRunner){
    private val response : TextView = textView

    //Buttons for testing only
    fun yesButton(){
        response.text = gameRunner.getString(R.string.yes_selection)
    }
    fun noButton(){
        response.text = gameRunner.getString(R.string.no_selection)
    }
    fun readJSONButton(){

    }


    //Status Changer - Alters the status of our player
        //if the player does something a character likes
            //Check for max status (CALL METHOD)
                //if not going to go over max status
                    //Add status
                //else set status to 100

        //else the player does something a character does not like
            //Check for min status (CALL METHOD)
                //if not going to go under min status
                    //Add status
                //else set status to 100


    //Money Changer - Alters the amount of money our player has
        //if player spends money
            //Check for min money (CALL METHOD)
                //if not going to go under 0
                    //take away money
                //else notify player

        //else the player earns money
            //add money to player

    //Energy Changer - Alters the amount of energy our player has
        //if player does an action
            //Check energy level (CALL METHOD)
                //if energy level > needed energy
                    //take away needed energy from energy level
                //else if energy level < needed energy
                    //Send player home
                //else player energy == 0
                    //Send player home

    //currentLocation Changer - Records current location of player
        //Store locations in an array list and refer to list by numbers

    //CheckMaxStatus()

    //CheckMinStats()

    //CheckMinMoney()

    //CheckEnergyLevel()
}
