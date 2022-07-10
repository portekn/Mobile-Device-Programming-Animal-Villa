package com.animal_villa

import android.os.Bundle
import android.provider.Settings.Global.getString
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
//import com.animal_villa.ui.theme.AnimalVillaTheme
import com.example.main_animal_villa.R
//import java.lang.reflect.Modifier

class GameFramework(textView: TextView, gameRunner: GameRunner){
    private val response : TextView = textView
    private val gameRunner = gameRunner

    //Buttons for testing only
    fun yesButton(){
        response.text = gameRunner.getString(R.string.yes_selection)
    }
    fun noButton(){
        response.text = gameRunner.getString(R.string.no_selection)
    }

    public void checkPlayerStats(){
        PlayGames.getPlayerStatsClient(this)
            .loadPlayerStats(true)
            .addOnCompleteListener(new OnCompletedListener<AnnotatedData<PlayerStats>>() {
                public void onComplete(Task<AnnotatedData<PlayerStats>> task){
                    if (CheckMaxStatus() = 100){
                        status = 100

                    if (CheckMaxStatus() < 100){
                        status = status +like
                    }

                    }if (CheckMinStatus() = 0){
                        status = 0
                    }

                    if (CheckMinStatus() > 0){
                        statuc = status - like
                    }

    
                }
            }
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
                    //take away needed enery from energy level
                //else if energy level < needed energy
                    //Send player home
                //else player enery == 0
                    //Send player home

    //currentLocation Changer - Records current location of player
        //Store locations in an array list and refer to list by numbers

    //CheckMaxStatus()

    //CheckMinStatus()

    //CheckMinMoney()

    //CheckEnergyLevel()
}
