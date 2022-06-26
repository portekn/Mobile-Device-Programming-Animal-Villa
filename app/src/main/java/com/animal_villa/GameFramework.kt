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
    val response : TextView = textView
    val gameRunner = gameRunner

    fun yesButton(){
        response.text = gameRunner.getString(R.string.yes_selection)
    }
    fun noButton(){
        response.text = gameRunner.getString(R.string.no_selection)
    }
}

        /* {
            AnimalVillaTheme {
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background

                play("Android")
            }



    }
}

fun play(name:String){
    //Put Variables Here

    Column {
    //Buttons and things go here

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AnimalVillaTheme {
        play(name = "")
    }
}
*/
