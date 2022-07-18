package app

import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import app.AnimalVilla.R
import app.DTO.Prompt
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread

class GamePlayModel: AppCompatActivity() {

    //Variables
    private var array:ArrayList<String> = arrayListOf() //Holds a list of array items for variables above. Will be used to add values to variables above

    override fun onCreate(savedInstanceState: Bundle?) {
        //Hides Action and Status bars
        supportActionBar?.hide()
        hideSystemBars()

        //Lets the game run
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_play)

        //Gets the first prompt
        organizeCurrentPrompt("0", array)

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
            organizeCurrentPrompt(array[1], array)
            textView.text = array[0]
            leftButtonTextView.text = array[4]
            rightButtonTextView.text = array[5]
        }

        //DO this when right button is pressed
        val rightButton = findViewById<Button>(R.id.rightButton)
        rightButton.setOnClickListener {
            //right button does things here
            organizeCurrentPrompt(array[2], array)
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
//Collects all prompts for use
private fun getAllPrompts(): MutableList<Prompt> {
    val queue = LinkedBlockingQueue<MutableList<Prompt>>()
    thread {
        try {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder().detectNetwork().permitAll().build()
            )
            val yahoo = URL("https://api.jsonbin.io/v3/b/62ca4dbc5d53821c3097eaef/")
            val inStream = BufferedReader(InputStreamReader(yahoo.openStream()))

            var inputLine = inStream.readLine()
            var data = ""

            while (inputLine != null) {
                data += inputLine
                inputLine = inStream.readLine()
            }
            inStream.close()

            val prompts = mutableListOf<Prompt>()
            val jRecord = JSONObject(data).get("record") as JSONObject
            var i = 1
            while (true) {
                if (!jRecord.has(i.toString()))
                    break

                val jPrompt = jRecord.get(i.toString()) as JSONObject

                //Prompt for the player
                val promptText = jPrompt.get("PromptText").toString()

                //Prompt id
                val id = jPrompt.get("id").toString().toInt()

                //Left Information
                val leftOption = jPrompt.get("LeftOption").toString()
                val leftMoney = jPrompt.get("LeftMoney").toString().toInt()
                val leftEnergy = jPrompt.get("LeftEnergy").toString().toInt()
                val leftStatus = jPrompt.get("LeftStatus").toString().toInt()
                val nextLeft = jPrompt.get("NextLeft").toString().toInt()

                //Right Information
                val rightOption = jPrompt.get("RightOption").toString()
                val rightMoney = jPrompt.get("RightMoney").toString().toInt()
                val rightEnergy = jPrompt.get("RightEnergy").toString().toInt()
                val rightStatus = jPrompt.get("RightStatus").toString().toInt()
                val nextRight = jPrompt.get("NextRight").toString().toInt()

                //println(" $promptText $leftOption $leftEnergy $leftMoney $leftStatus $rightOption $rightEnergy $rightMoney $rightStatus $nextLeft $nextRight $id")
                prompts.add(
                    Prompt(promptText, leftOption, leftEnergy, leftMoney, leftStatus, rightOption, rightEnergy, rightMoney, rightStatus, nextLeft, nextRight, id
                    )
                )
                i++
            }
            queue.add(prompts)
        } catch (e: Exception) {
            queue.add(null)
        }
    }
    return queue.take()
}

//Collects needed prompt for use
private fun organizeCurrentPrompt(fetch: String, array: ArrayList<String>): ArrayList<String> {

    //Assign values to prompts
    val queue = getAllPrompts()

    array.add(0,queue[fetch.toInt()].PromptText)
    array.add(1,queue[fetch.toInt()].NextLeft.toString())
    array.add(2,queue[fetch.toInt()].NextRight.toString())
    array.add(3,queue[fetch.toInt()].id.toString())
    array.add(4,queue[fetch.toInt()].LeftOption)
    array.add(5,queue[fetch.toInt()].RightOption)
    array.add(6,queue[fetch.toInt()].LeftEnergy.toString())
    array.add(7,queue[fetch.toInt()].RightEnergy.toString())
    array.add(8,queue[fetch.toInt()].LeftMoney.toString())
    array.add(9,queue[fetch.toInt()].RightMoney.toString())
    array.add(10,queue[fetch.toInt()].LeftStatus.toString())
    array.add(11,queue[fetch.toInt()].RightStatus.toString())

    //Return array for use
    return array
    }
