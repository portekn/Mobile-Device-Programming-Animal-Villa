package com.animal_villa

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.main_animal_villa.R
import com.google.gson.Gson
import retrofit2.http.POST
import java.io.BufferedReader
import java.io.File
import java.lang.StringBuilder


class GameRunner : ComponentActivity() {
private lateinit var gameFramework: GameFramework
private var stringBuilder:StringBuilder?=null
    private var textView: TextView?=null

    fun startGame() {
        setContentView(R.layout.game_main)
        gameFramework = GameFramework(findViewById(R.id.response),this)
        val yesButton = findViewById<Button>(R.id.left_button)
        val noButton = findViewById<Button>(R.id.right_button)
        val readJSON = findViewById<Button>(R.id.readJSONButton)
        yesButton.setOnClickListener(YesButtonClicked(gameFramework))
        noButton.setOnClickListener(NoButtonClicked(gameFramework))
        readJSON.setOnClickListener(ReadJSONButtonClicked(gameFramework))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)

        // Get the file Location and name where Json File are get stored
        val context = cacheDir.absolutePath+"/Tutorial.json"
        readJSONButton(context)
    }

    private fun readJSONButton(context: String){
        //Create Gson Object
        val gson = Gson()

        //Read JSON File
        val bufferedReader: BufferedReader = File(context).bufferedReader()

        //Read text from buffer reader
        val inputString = bufferedReader.use{it.readText()}

        //Convert Json file to Gson object
        val post = gson.fromJson(inputString, POST::class.java)

        //Initialize String Builder
        stringBuilder = StringBuilder("Prompt:")
        Log.d("Kotlin", post.value)
        stringBuilder?.append("\nPrompt:" + post.value)
        stringBuilder?.append("\nMoney:" + post.value)
        stringBuilder?.append("\nTags:")

        //Get all Tags
        post.value.forEach{ tag -> stringBuilder?.append("$tag,")}

        //Display in text view
        textView?.text = stringBuilder.toString()
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

class ReadJSONButtonClicked(gameFramework: GameFramework) : View.OnClickListener{
    private val gameFrame = gameFramework

    override fun onClick(view: View) {
        gameFrame.readJSONButton()
    }
}