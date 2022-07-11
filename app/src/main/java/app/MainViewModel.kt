package app

import androidx.lifecycle.ViewModel
import app.Service.IPromptService
import app.Service.PromptService
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.storage.FirebaseStorage

class MainViewModel (var promptService : IPromptService) : ViewModel(){

    //Variables
    var prompts = promptService.getLocalPromptDAO().getPrompts()


    //Firebase
    private var firestore : FirebaseFirestore = FirebaseFirestore.getInstance()
    private var storageReference = FirebaseStorage.getInstance().reference
    init {
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    //Fetch Prompts
    //Get prompt from array list and present it to the user
    //ADD FUNCTION HEREEREERE

    //Left Button
    //Program searches through list for corresponding number and everything loops

    //Right Button
    //Program searches through list for corresponding number and everything loops

    //Player Stats
    //Adjust the players stats with corresponding number in array list
}