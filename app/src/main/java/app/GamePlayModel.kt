package app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import app.AnimalVilla.R
import org.w3c.dom.Text
import java.util.zip.Inflater

class GamePlayModel : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()

        hideSystemBars()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_play)

            //DO STUFF HERE
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