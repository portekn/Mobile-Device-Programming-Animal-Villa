package com.animal_villa

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Looper(
    @SerializedName("Prompt") @Expose var Prompt: String? = null,
    @SerializedName("Energy") @Expose var Energy: Int? = null,
    @SerializedName("Money") @Expose var Money: Int? = null,
    @SerializedName("Status") @Expose var Status: Int? = null,
    @SerializedName("Left") @Expose var Left: Int? = null,
    @SerializedName("Right") @Expose var Right: Int? = null
)