package app

import android.os.Bundle
import android.view.View
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

        val textView: TextView = findViewById(R.id.promptBox)
        val nextDayButton: Button = findViewById(R.id.nextDayButton)
        val rightButton: Button = findViewById(R.id.rightButton)
        val leftButton: Button = findViewById(R.id.leftButton)

        //Gets the first prompt
        getInformation.organizeCurrentPrompt("0", array)

        //Checks what day the game is on
        checkDay(array[12].toBoolean(), leftButton, rightButton, nextDayButton)

        //Displays first prompt
        textView.text = array[0]

        //Label the buttons
        val leftButtonTextView = findViewById<Button>(R.id.leftButton)
        val rightButtonTextView = findViewById<Button>(R.id.rightButton)
        val nextDayButtonTextView = findViewById<Button>(R.id.nextDayButton)
        leftButtonTextView.text = array[4]
        rightButtonTextView.text = array[5]
        nextDayButtonTextView.text = "Go to next Day"

        //Do this when left button is pressed
        leftButton.setOnClickListener {
            //left button does things here
            changeButtonsAndText(
                array,
                textView,
                leftButtonTextView,
                rightButtonTextView,
                nextDayButtonTextView
            )
        }

        //Do this when right button is pressed
        rightButton.setOnClickListener {
            //right button does things here
            changeButtonsAndText(
                array,
                textView,
                leftButtonTextView,
                rightButtonTextView,
                nextDayButtonTextView
            )
            checkDay(array[12].toBoolean(), leftButton, rightButton, nextDayButton)
        }

        //Do this when next day button is pressed
        nextDayButton.setOnClickListener{
            //next day button does things here
            changeButtonsAndText(
                array,
                textView,
                leftButtonTextView,
                rightButtonTextView,
                nextDayButtonTextView
            )
            checkDay(array[12].toBoolean(), leftButton, rightButton, nextDayButton)

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


    fun showButtons(leftButton: Button, rightButton: Button, nextDayButton: Button) {
        leftButton.visibility = View.VISIBLE
        rightButton.visibility = View.VISIBLE
        nextDayButton.visibility = View.GONE
    }

    fun hideButtons(leftButton: Button, rightButton: Button, nextDayButton: Button) {
        leftButton.visibility = View.GONE
        rightButton.visibility = View.GONE
        nextDayButton.visibility = View.VISIBLE
    }

    //Get json for correct day
    private fun checkDay(NextDay: Boolean, leftButton: Button, rightButton: Button, nextDayButton: Button) {
        if(NextDay){
            hideButtons(leftButton, rightButton, nextDayButton)
            getInformation.nextDayCounter()
        }
        else{
            showButtons(leftButton, rightButton, nextDayButton)
        }
    }

    private fun changeButtonsAndText(
        array: ArrayList<String>,
        textView: TextView,
        leftButtonTextView: Button,
        rightButtonTextView: Button,
        nextDayButtonTextView: Button
    ) {
        getInformation.organizeCurrentPrompt(array[2], array)
        textView.text = array[0]
        leftButtonTextView.text = array[4]
        rightButtonTextView.text = array[5]
        nextDayButtonTextView.text = "Go To Next Day..."
    }
}