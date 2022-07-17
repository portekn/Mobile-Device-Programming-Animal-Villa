package app

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import app.AnimalVilla.R
import app.DTO.Prompt
import org.json.JSONObject
import org.w3c.dom.Text
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.LinkedBlockingQueue
import java.util.zip.Inflater
import kotlin.concurrent.thread

class GamePlayModel: AppCompatActivity() {

    //Variables
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        hideSystemBars()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_play)

        val queue = getAllPrompts()
        //println( queue?.get(2).toString())
        //DO STUFF HERE


        val textView = findViewById<TextView>(R.id.promptBox)
        //textView.setOnClickListener{ Toast.makeText(this@GamePlayModel,
        //   R.string.text_on_click, Toast.LENGTH_LONG).show() }
        textView.text = queue?.get(2).toString()

    }

    //Hides the system bars when app is running
    //Need to put somewhere else
    private fun hideSystemBars() {
        val windowInsetsController =
            WindowCompat.getInsetsController(window, findViewById(R.id.GamePlay))
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }
}

private fun getAllPrompts(): MutableList<Prompt>? {
    val queue = LinkedBlockingQueue<MutableList<Prompt>?>()
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

            /*array way
        val jRecords= JSONObject(data).get("record") as JSONArray;
        println("RECORD");
        println(jRecords.toString())
        for (i in 0 until jRecords.length()){
            val jPrompt=jRecords.get(i) as JSONObject
            //println(jPrompt)
            val promptText=jPrompt.get("PromptText").toString()
            val energy=jPrompt.get("Energy").toString().toInt()
            val money=jPrompt.get("Money").toString().toInt()
            val status=jPrompt.get("Status").toString().toInt()
            val left=jPrompt.get("Left").toString().toInt()
            val right=jPrompt.get("Right").toString().toInt()
            println("{" +
                    "\n promptText: "+promptText +
                    "\n energy: "+energy +
                    "\n money: "+money +
                    "\n status: "+status +
                    "\n left: "+left +
                    "\n right: "+right +
                    "\n}")
            prompts.add(Prompt(promptText,energy,money,status,left,right))
        }
        */

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
                    Prompt(
                        promptText,
                        leftOption,
                        leftEnergy,
                        leftMoney,
                        leftStatus,
                        rightOption,
                        rightEnergy,
                        rightMoney,
                        rightStatus,
                        nextLeft,
                        nextRight,
                        id
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