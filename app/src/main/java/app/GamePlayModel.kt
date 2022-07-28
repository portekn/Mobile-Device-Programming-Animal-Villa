package app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import app.AnimalVilla.R

class GamePlayModel: AppCompatActivity() {

    //Variables
    private val getInformation = GetInformation()
    private var array:ArrayList<String> = arrayListOf() //Holds a list of array items for variables above. Will be used to add values to variables above

    override fun onCreate(savedInstanceState: Bundle?) {
        //Hides Action and Status bars
        supportActionBar?.hide()
        hideSystemBars()

        //Lets the game run
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_play)

        //Gets the first prompt
       getInformation.organizeCurrentPrompt("0", array)

        //Checks what day the game is on
        getInformation.checkDay(array[12].toBoolean())

        //Displays first prompt
        val textView = findViewById<TextView>(R.id.promptBox)
        textView.text = array[0]

        //Label the buttons
        val leftButtonTextView = findViewById<Button>(R.id.leftButton)
        val rightButtonTextView = findViewById<Button>(R.id.rightButton)
        leftButtonTextView.text = array[4]
        rightButtonTextView.text = array[5]

        //Do this when left button is pressed
        val leftButton = findViewById<Button>(R.id.leftButton)
        leftButton.setOnClickListener {
            //left button does things here
            getInformation.organizeCurrentPrompt(array[1], array)
            textView.text = array[0]
            leftButtonTextView.text = array[4]
            rightButtonTextView.text = array[5]
        }

        //DO this when right button is pressed
        val rightButton = findViewById<Button>(R.id.rightButton)
        rightButton.setOnClickListener {
            //right button does things here
            getInformation.organizeCurrentPrompt(array[2], array)
            textView.text = array[0]
            leftButtonTextView.text = array[4]
            rightButtonTextView.text = array[5]
        }
    }

    //Hides the system bars when app is running
    private fun hideSystemBars() {
        val windowInsetsController =
            WindowCompat.getInsetsController(window, findViewById(R.id.GamePlay))
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }
}