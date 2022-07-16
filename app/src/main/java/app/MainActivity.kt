package app

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import app.AnimalVilla.R
//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.firestore.FirebaseFirestore

open class MainActivity : ComponentActivity() {


    //Variables
    private lateinit var mainViewModel: MainViewModel
    private lateinit var gameplay: GamePlayModel
    private var textView: TextView?=null
    //private var firebaseUser: FirebaseUser? = null
    //private latent var firestore: FirebaseFirestore

    private fun startGame(view: View){
        setContentView(R.layout.game_play)
        mainViewModel = MainViewModel(findViewById(R.id.promptBox), this)
        gameplay = GamePlayModel(findViewById<TextView>(R.id.promptBox),this)

        //Buttons
        val startButton = findViewById<Button>(R.id.StartButton)
        val leftButton = findViewById<Button>(R.id.leftButton)
        val rightButton = findViewById<Button>(R.id.rightButton)

        //Button Listeners
        startButton.setOnClickListener(StartButtonClicked(mainViewModel))
        leftButton.setOnClickListener(LeftButtonClicked(gameplay))
        rightButton.setOnClickListener(RightButtonClicked(gameplay))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.GamePlay)
        }

    //Start game when button is pressed
    class StartButtonClicked(mainViewModel: MainViewModel): View.OnClickListener{
        private val mainView = mainViewModel
        override fun onClick(view: View){
            mainView.startButton()
        }
    }

    //Do something when left button is pressed
    class LeftButtonClicked(gameplay: GamePlayModel): View.OnClickListener{
        private val mainView = gameplay
        override fun  onClick(view:View){
            mainView.leftButton()
        }
    }

    //Do something when right button is pressed
    class RightButtonClicked(gameplay: GamePlayModel): View.OnClickListener{
        private val mainView = gameplay
        override fun  onClick(view:View){
            mainView.rightButton()
        }
    }

}