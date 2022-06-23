package com.animal_villa

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.animal_villa.ui.theme.AnimalVillaTheme
import java.lang.reflect.Modifier

class GameFramework : ComponentActivity() {
    override fun onCreate(savedInstancesState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            AnimalVillaTheme {
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background

                play("Android")
            }
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