package com.example.weathercomposeapp.data.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("EnglishName") val englishName: String,
    @SerializedName("ID") val id: String,
    @SerializedName("LocalizedName") val localizedName: String
)