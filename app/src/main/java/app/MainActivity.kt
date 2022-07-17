package app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.*
import app.AnimalVilla.R
//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.firestore.FirebaseFirestore

open class MainActivity : AppCompatActivity() {

    //Variables

    //Firebase
    //private var firebaseUser: FirebaseUser? = null
    //private latent var firestore: FirebaseFirestore

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
    private fun hideSystemBars() {
        val windowInsetsController =
            WindowCompat.getInsetsController(window, findViewById(R.id.TitleScreen))
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
        }
    }

