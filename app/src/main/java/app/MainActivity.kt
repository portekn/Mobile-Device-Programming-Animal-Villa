package app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.compose.ui.Modifier.Companion.any
import app.AnimalVilla.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext.startKoin

//import app.DTO.Specimen
//import app.DTO.foo

//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.firestore.FirebaseFirestore

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

