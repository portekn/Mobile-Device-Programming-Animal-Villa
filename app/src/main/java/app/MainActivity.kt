package app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import app.AnimalVilla.R

//import app.DTO.Specimen
//import app.DTO.foo

//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.firestore.FirebaseFirestore

open class MainActivity : AppCompatActivity() {

    //Variables
    //val appMethods = AppMethods()

    //Firebase
    //private var firebaseUser: FirebaseUser? = null
    //private latent var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        //appMethods.hideSystemBars(supportActionBar,window,findViewById(R.id.TitleScreen))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


/*
        var length = foo?.let{

            it.toString()

        } ?: -1
*/


        //Press the start button to start the game
        //val startButton = findViewById<Button>(R.id.StartButton)
        //startButton.setOnClickListener {
        //    val int = Intent(this, GamePlayModel::class.java)
        //    startActivity(int)
        //}
    }

    fun gotoLogin(view: View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    fun gotoReg(view: View) {
        startActivity(Intent(this, RegistrationActivity::class.java))
    }
}

