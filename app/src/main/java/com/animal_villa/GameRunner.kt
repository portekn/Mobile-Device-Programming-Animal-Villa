package com.animal_villa

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.main_animal_villa.R


class GameRunner : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
// @Composable
// fun Open(){
// Text(text= "Testing Application")
// }
//
// @Preview(showBackground = true)
// @Composable
// fun DefaultPreview(){
// AnimalVillaTheme {
// Open("Android")
// }