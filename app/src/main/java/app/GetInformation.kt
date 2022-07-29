package app

import android.os.StrictMode
import app.DTO.Prompt
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread

class GetInformation {

    //Online json sources Days
    private val tutorial:String = "https://api.jsonbin.io/v3/b/62ca4dbc5d53821c3097eaef/"
    private val monday:String ="https://api.jsonbin.io/v3/b/62dca97c248d43754f01ac03"
    private val tuesday:String="https://api.jsonbin.io/v3/b/62dca9dc8ebcdb75883e16c5"
    private val wednesday:String=""
    private val thursday:String=""
    private val friday:String=""
    private val saturday:String=""
    private val sunday:String=""

    private val infoList = listOf(tutorial,monday,tuesday,wednesday,thursday,friday,saturday,sunday)
    private var i: Int = 0

    //Get json for correct day
    fun checkDay(NextDay: Boolean) {
        if(NextDay){
            this.i = i+1
        }
        println(i)
    }


    //Get json for correct ending
    //Online json sources Endings
    private val badEnding:String=""
    private val exaustedEnding:String=""
    private val goodEnding:String=""
    private val pennilessEnding:String=""

    //Collects all prompts for use
    private fun getAllPrompts(): MutableList<Prompt> {
        val queue = LinkedBlockingQueue<MutableList<Prompt>>()
        thread {
            try {
                StrictMode.setThreadPolicy(
                    StrictMode.ThreadPolicy.Builder().detectNetwork().permitAll().build()
                )
                val yahoo = URL(infoList[i])
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

                    //Next Day Information
                    val nextDay = jPrompt.get("NextDay").toString().toBoolean()

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
                            id,
                            nextDay
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
    fun organizeCurrentPrompt(fetch: String, array: ArrayList<String>): ArrayList<String> {

        //Assign values to prompts
        val queue = getAllPrompts()

        array.add(0, queue[fetch.toInt()].PromptText)
        array.add(1, queue[fetch.toInt()].NextLeft.toString())
        array.add(2, queue[fetch.toInt()].NextRight.toString())
        array.add(3, queue[fetch.toInt()].id.toString())
        array.add(4, queue[fetch.toInt()].LeftOption)
        array.add(5, queue[fetch.toInt()].RightOption)
        array.add(6, queue[fetch.toInt()].LeftEnergy.toString())
        array.add(7, queue[fetch.toInt()].RightEnergy.toString())
        array.add(8, queue[fetch.toInt()].LeftMoney.toString())
        array.add(9, queue[fetch.toInt()].RightMoney.toString())
        array.add(10, queue[fetch.toInt()].LeftStatus.toString())
        array.add(11, queue[fetch.toInt()].RightStatus.toString())
        array.add(12, queue[fetch.toInt()].NextDay.toString())

        //Return array for use
        return array
    }
}