package com.animal_villa

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.main_animal_villa.DisplayMessageActivity
import com.example.main_animal_villa.R


class GameRunner : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun startGame(view: View) {
        //Do something in response to the button press
        val editText = findViewById<EditText>(R.id.editTextTextPersonName2)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
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