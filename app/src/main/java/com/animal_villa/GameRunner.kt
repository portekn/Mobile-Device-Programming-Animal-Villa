package com.animal_villa

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.annotation.ContentView
import com.example.main_animal_villa.R


class GameRunner : ComponentActivity() {
lateinit var gameFramework: GameFramework

    fun startGame(view: View) {
        setContentView(R.layout.game_main)
        gameFramework = GameFramework(findViewById<TextView>(R.id.response), this)
        val yesButton = findViewById<Button>(R.id.left_button)
        val noButton = findViewById<Button>(R.id.right_button)
        yesButton.setOnClickListener(YesButtonClicked(gameFramework))
        noButton.setOnClickListener(NoButtonClicked(gameFramework))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

class YesButtonClicked(gameFramework: GameFramework) : View.OnClickListener{
    val gameFrame = gameFramework
    override fun onClick(view: View){
        gameFrame.yesButton()
    }
}

class NoButtonClicked(gameFramework: GameFramework) : View.OnClickListener{
    val gameFrame = gameFramework
    override fun onClick(view: View){
        gameFrame.noButton()
    }
}