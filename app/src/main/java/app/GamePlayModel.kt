package app

import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
    var PromptText:  String = ""//0 Text displayed to the player aka dialogue
    var LeftOption:  String = ""//1 Text displayed to the player as a choice for left option
    var RightOption: String = ""//2 Text displayed to the player as a choice for right option
    var LeftEnergy:  Int    = 0 //3 How much energy will be used if selecting left option
    var LeftMoney:   Int    = 0 //4 How much money will be gained or lost if selecting left option
    var LeftStatus:  Int    = 0 //5 How many status points the player will gain or lose if selecting the left option
    var RightEnergy: Int    = 0 //6 How much energy will be used if selecting the right option
    var RightMoney:  Int    = 0 //7 How much money will be gained or lost if selecting the right option
    var RightStatus: Int    = 0 //8 How many status points the player will gain or lose if selecting the right option
    var NextLeft:    Int    = 0 //9 id of the next prompt to fetch for the player if selecting the left option
    var NextRight:   Int    = 0 //10 id of the next prompt to fetch for the player if selecting the right option
    var id:          Int    = 0 //11 id of the current prompt
    var fetch:       Int    = 0 //Holds the id number of the next prompt to fetch
    private var array:ArrayList<String> = arrayListOf() //Holds a list of array items for variables above. Will be used to add values to variables above

    override fun onCreate(savedInstanceState: Bundle?) {
        //Hides Action and Status bars
        supportActionBar?.hide()
        hideSystemBars()

        //Lets the game run
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_play)

        //Gets the first prompt
        organizeCurrentPrompt(fetch, array)

        //Assigns variables for easy access
        //assignVariables()

        //Displays first prompt
        val textView = findViewById<TextView>(R.id.promptBox)
        textView.setText(array[0])

        //val textView = findViewById<TextView>(R.id.promptBox)
        //textView.setOnClickListener{ Toast.makeText(this@GamePlayModel,
        //   R.string.text_on_click, Toast.LENGTH_LONG).show() }
        //textView.text = queue?.get(2).toString()

        //Do this when left button is pressed
        val leftButton = findViewById<Button>(R.id.leftButton)
        leftButton.setOnClickListener {
            //left button does things here
            fetch = array[1].toInt()
            println(fetch)
            organizeCurrentPrompt(fetch, array)
            //assignVariables()
            textView.setText(array[0])
        }

        //DO this when right button is pressed
        val rightButton = findViewById<Button>(R.id.rightButton)
        rightButton.setOnClickListener {
            //right button does things here
            fetch = array[2].toInt()
            println(fetch)
            organizeCurrentPrompt(fetch, array)
            //assignVariables()
            textView.setText(array[0])
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

    //Assigns variables for use
    private fun assignVariables(){
        array.set(index = 0,array[0])
        array.set(index = 9,array[9])
        array.set(index = 10,array[10])
        array.set(index = 11,array[11])

        array[1] = array[1]
        array[2] = array[2]
        array[3] = array[3]
        array[4] = array[4]
        array[5] = array[5]
        array[6] = array[6]
        array[7] = array[7]
        array[8] = array[8]
        /*
        PromptText = array[0]
        LeftOption = array[1]
        RightOption= array[2]
        LeftEnergy = array[3].toInt()
        LeftMoney = array[4].toInt()
        LeftStatus = array[5].toInt()
        RightEnergy = array[6].toInt()
        RightMoney = array[7].toInt()
        RightStatus = array[8].toInt()
        NextLeft = array[9].toInt()
        NextRight = array[10].toInt()
        id = array[11].toInt()

         */
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
            var data = "";

            while (inputLine != null) {
                data += inputLine;
                inputLine = inStream.readLine();
            }
            inStream.close()

            val prompts = mutableListOf<Prompt>()
            val jRecord = JSONObject(data).get("record") as JSONObject;
            var i = 1;
            while (true) {
                if (!jRecord.has(i.toString()))
                    break;

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
    return queue.take();
}

//Collects needed prompt for use
private fun organizeCurrentPrompt(fetch:Int, array: ArrayList<String>): ArrayList<String> {

    //Assign values to prompts
    val queue = getAllPrompts()

    array.add(0,queue[fetch].PromptText)
    array.add(1,queue[fetch].NextLeft.toString())
    array.add(2,queue[fetch].NextRight.toString())
    array.add(3,queue[fetch].id.toString())

    //Return array for use
    return array
    }
