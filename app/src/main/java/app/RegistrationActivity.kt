@file:Suppress("CanBeVal", "CanBeVal")

package app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import app.AnimalVilla.R
import app.DTO.Player
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private var firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
    private lateinit var auth: FirebaseAuth

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_registration)

    auth = FirebaseAuth.getInstance()
}

fun registerUser(view: View) {

    var email: String = findViewById<EditText>(R.id.email_edit_text).text.toString()
    var password: String = findViewById<EditText>(R.id.password_edit_text).text.toString()

    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                firebaseUser?.let {
                    val player = Player(status = 50, money = 50, energy = 50,uid="")
                    viewModel.save(player)
                }
                startActivity(Intent(this, GamePlayModel::class.java))

            } else {
                Toast.makeText(this, "An error occurred", Toast.LENGTH_SHORT).show()
            }
        }
}
}