package app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import app.AnimalVilla.R

open class MainActivity : AppCompatActivity() {

    //Variables
    private val appMethods = AppMethods()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appMethods.hideSystemBars(actionBar,window, findViewById(R.id.TitleScreen))
    }

    fun gotoLogin(view: View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    fun gotoReg(view: View) {
        startActivity(Intent(this, RegistrationActivity::class.java))
    }
}

