package app

import android.os.StrictMode
import android.view.View
import androidx.lifecycle.MutableLiveData
import app.DTO.Prompt
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread

class MainViewModel(textView: View, mainViewModel: MainActivity){

    //Variables
    //val output: TextView = textView
    //val mainViewModel = mainViewModel
    //private lateinit var _prompts: MutableList<MutableList<Prompt>>

    //Firebase
    private var firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    //private var storageReference = FirebaseStorage.getInstance().reference

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun startButton(){

        val queue = getAllPrompts()
       println( queue?.get(2).toString())
    }
}

    //Get All Prompts
    //Get prompt from array list and present it to the user
fun getAllPrompts(): MutableList<Prompt>? {
    val queue= LinkedBlockingQueue<MutableList<Prompt>?>()
    thread {
        try{
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().detectNetwork().permitAll().build())
            val yahoo = URL("https://api.jsonbin.io/v3/b/62ca4dbc5d53821c3097eaef/")
            val inStream = BufferedReader(InputStreamReader(yahoo.openStream()))

            var inputLine = inStream.readLine()
            var data = "";

            while (inputLine != null) {
                //println(inputLine)
                data += inputLine;
                inputLine = inStream.readLine();
            }
            inStream.close()

            val prompts = mutableListOf<Prompt>()
            //array way
            /*
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
                //println(jPrompt) //Testing
                val promptText = jPrompt.get("PromptText").toString()
                val energy = jPrompt.get("Energy").toString().toInt()
                val money = jPrompt.get("Money").toString().toInt()
                val status = jPrompt.get("Status").toString().toInt()
                val left = jPrompt.get("Left").toString().toInt()
                val right = jPrompt.get("Right").toString().toInt()
                println("$promptText $energy $money $status $left $right")
                prompts.add(Prompt(promptText, energy, money, status, left, right))
                i++
            }
            queue.add(prompts)
        }catch(e:Exception){
            queue.add(null)
        }
    }
    return queue.take();
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
