package com.animal_villa.dao

import com.animal_villa.dto.Character
import retrofit2.Call
import androidx.room.Dao
import retrofit2.http.GET


interface ICharacterListDAO {
    @GET()
    fun getCharacter(): Call<ArrayList<Character>>
}