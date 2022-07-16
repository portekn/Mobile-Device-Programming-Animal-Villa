package app

import android.os.Bundle
import android.os.StrictMode
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import app.AnimalVilla.R.*
import app.DAO.IPromptDAO
import app.DTO.Prompt
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        findViewById<Button>(id.StartButton).setOnClickListener{
            println("button clicked")
            //Thread {
              //  runOnUiThread {
                    println(getPrompts()!!.size.toString()+" SIZE")

            }

    }
    /**
    Avoids Retrofit by self parsing
    Returns a MutableList of prompts ordered by prompt number
    Returns null if an error occurred
     */
    fun getPrompts(): MutableList<Prompt>? {
        val queue= LinkedBlockingQueue<MutableList<Prompt>?>()
        thread {
            try{
            //StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().detectNetwork().permitAll().build())
            val yahoo = URL("https://api.jsonbin.io/v3/b/62ca4dbc5d53821c3097eaef/")
            val inStream = BufferedReader(InputStreamReader(yahoo.openStream()))

            var inputLine = inStream.readLine()
            var data = "";

            while (inputLine != null) {
                println(inputLine)
                data += inputLine;
                inputLine = inStream.readLine();
            }
            inStream.close()

            val prompts = mutableListOf<Prompt>()
            //array way
            /*val jRecords=JSONObject(data).get("record") as JSONArray;
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
        }*/

            val jRecord = JSONObject(data).get("record") as JSONObject;
            var i = 1;
            while (true) {
                if (!jRecord.has(i.toString()))
                    break;

                val jPrompt = jRecord.get(i.toString()) as JSONObject
                println(jPrompt)
                val promptText = jPrompt.get("PromptText").toString()
                val energy = jPrompt.get("Energy").toString().toInt()
                val money = jPrompt.get("Money").toString().toInt()
                val status = jPrompt.get("Status").toString().toInt()
                val left = jPrompt.get("Left").toString().toInt()
                val right = jPrompt.get("Right").toString().toInt()
                println("{" +
                        "\n promptText: " + promptText +
                        "\n energy: " + energy +
                        "\n money: " + money +
                        "\n status: " + status +
                        "\n left: " + left +
                        "\n right: " + right +
                        "\n}")
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

}
