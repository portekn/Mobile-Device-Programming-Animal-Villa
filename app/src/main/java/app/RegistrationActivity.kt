@file:Suppress("CanBeVal", "CanBeVal")

package app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import app.AnimalVilla.R
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {

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
                startActivity(Intent(this, GamePlayModel::class.java))
            } else {
                Toast.makeText(this, "An error occurred", Toast.LENGTH_SHORT).show()
            }
        }
}
}