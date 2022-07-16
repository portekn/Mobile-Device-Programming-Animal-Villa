package app

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ScrollView
import androidx.activity.ComponentActivity
import app.AnimalVilla.R
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {

    //Variables
    lateinit var mainViewModel: MainViewModel
    private var firebaseUser: FirebaseUser? = null
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(findViewById<ScrollView>(R.id.scroll), this)
        val startButton = findViewById<Button>(R.id.StartButton)
        startButton.setOnClickListener(startButtonClicked(mainViewModel))
        }


    class startButtonClicked(mainViewModel: MainViewModel): View.OnClickListener{
        private val mainView = mainViewModel
        override fun onClick(view: View){
            mainView.startButton()
        }
    }

}