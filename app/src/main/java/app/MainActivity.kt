package app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.*
import androidx.core.view.ViewCompat.getWindowInsetsController
import app.AnimalVilla.R
//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.firestore.FirebaseFirestore

open class MainActivity : AppCompatActivity() {

    //Variables
    private lateinit var mainViewModel: MainViewModel
    private lateinit var gameplay: GamePlayModel
    private var textView: TextView? = null

    //Firebase
    //private var firebaseUser: FirebaseUser? = null
    //private latent var firestore: FirebaseFirestore

    private fun startGame(view: View) {
        //setContentView(R.layout.game_play)
        //mainViewModel = MainViewModel(findViewById(R.id.promptBox), this)
        //gameplay = GamePlayModel(findViewById<TextView>(R.id.promptBox),this)

        //Buttons
        //val startButton = findViewById<Button>(R.id.StartButton)
        //val leftButton = findViewById<Button>(R.id.leftButton)
        //val rightButton = findViewById<Button>(R.id.rightButton)

        //Button Listeners
        //startButton.setOnClickListener(StartButtonClicked())
        //leftButton.setOnClickListener(LeftButtonClicked(gameplay))
        ///rightButton.setOnClickListener(RightButtonClicked(gameplay))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        hideSystemBars()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Press the start button to start the game
        val startButton = findViewById<Button>(R.id.StartButton)
        startButton.setOnClickListener {
            val int = Intent(this, GamePlayModel::class.java)
            startActivity(int)
        }
    }

    //Hides the system bars when app is running
    //Need to put somewhere else
    private fun hideSystemBars() {
        val windowInsetsController =
            WindowCompat.getInsetsController(window, findViewById(R.id.TitleScreen))
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
        }
    }

    //Do something when left button is pressed
    class LeftButtonClicked(gameplay: GamePlayModel) : View.OnClickListener {
        private val mainView = gameplay
        override fun onClick(view: View) {
            //mainView.leftButton()
        }
    }

    //Do something when right button is pressed
    class RightButtonClicked(gameplay: GamePlayModel) : View.OnClickListener {
        private val mainView = gameplay
        override fun onClick(view: View) {
            //mainView.rightButton()
        }
    }

