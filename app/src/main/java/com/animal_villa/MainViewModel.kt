package com.animal_villa

import com.animal_villa.dto.Settings
import com.animal_villa.dto.Storage
import com.animal_villa.dto.Character
import com.animal_villa.dto.Player
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

//import kotlinx.coroutines.launch

class MainViewModel: ViewModel(){
    private lateinit var firestore : FirebaseFirestore

    init{
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun save(){
        //firestore.collection()
    }

}