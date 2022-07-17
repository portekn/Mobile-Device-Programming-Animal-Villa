package app

import android.content.Intent
import android.os.StrictMode
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isVisible
import app.DTO.Prompt
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.storage.FirebaseStorage
import org.json.JSONObject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread

class MainViewModel(textView: TextView, private val mainViewModel: MainActivity) {

    //Variables
    var queue = getAllPrompts()
    var respose: TextView = textView


    //Firebase
    private var firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var storageReference = FirebaseStorage.getInstance().reference

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    //Get All Prompts for use in the app
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
}


    //Select next prompt
    //if left button, pull this prompt
    //else right button, pull this prompt

    //Left Button
    //Program searches through list for corresponding number and everything loops

    //Right Button
    //Program searches through list for corresponding number and everything loops

    //Player Stats
    //Adjust the players stats with corresponding number in array list
