package com.animal_villa

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.main_animal_villa.R
import java.io.IOException


class GameRunner : ComponentActivity() {
private lateinit var gameFramework: GameFramework
    private var textView: TextView?=null
    private val file: String = "Tutorial.json"


    fun startGame(view: View) {
        //Reads the JSON file on start button push
        readJsonAsset(file)

        setContentView(R.layout.game_main)
        gameFramework = GameFramework(findViewById<TextView>(R.id.response),this)
        val yesButton = findViewById<Button>(R.id.left_button)
        val noButton = findViewById<Button>(R.id.right_button)
        yesButton.setOnClickListener(YesButtonClicked(gameFramework))
        noButton.setOnClickListener(NoButtonClicked(gameFramework))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)

    }

    //Read Json File and Store Variable
    @Throws(IOException::class)
    fun Context.readJsonAsset(fileName: String): String {
        val inputStream = assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        println(String(buffer,Charsets.UTF_8))
        return String(buffer, Charsets.UTF_8)
    }

}


class YesButtonClicked(gameFramework: GameFramework) : View.OnClickListener{
    private val gameFrame = gameFramework
    override fun onClick(view: View){
        gameFrame.yesButton()
    }
}

class NoButtonClicked(gameFramework: GameFramework) : View.OnClickListener{
    private val gameFrame = gameFramework
    override fun onClick(view: View){
        gameFrame.noButton()
    }
}
