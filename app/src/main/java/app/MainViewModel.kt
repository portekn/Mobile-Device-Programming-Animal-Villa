package app

import androidx.lifecycle.ViewModel
import app.DTO.Player
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.storage.FirebaseStorage

class MainViewModel : ViewModel(){

    //Variables
    var player : Player? = null
    private var firestore : FirebaseFirestore = FirebaseFirestore.getInstance()
    private var storageReference = FirebaseStorage.getInstance().reference


    init {
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }
    fun save(player: Player){
        firestore.collection("players").document(player.uid).set(player)
    }
}