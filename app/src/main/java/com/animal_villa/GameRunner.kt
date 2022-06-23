package com.animal_villa

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.animal_villa.ui.theme.AnimalVillaTheme
import java.lang.reflect.Modifier

class GameRunner : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            AnimalVillaTheme {
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
                {
                    Open("Android")
                }
            }
        }
    }
}
@Composable
fun Open(){
    Text(text= "Testing Application")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    AnimalVillaTheme {
        Open("Android")
    }
}