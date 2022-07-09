package com.animal_villa

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Looper(
    val Prompt: String,
    val Energy: Int,
    val Money: Int,
    val Status: Int,
    val Left : Int,
    val Right: Int
)