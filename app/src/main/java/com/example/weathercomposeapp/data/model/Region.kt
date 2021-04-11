package com.example.weathercomposeapp.data.model

import com.google.gson.annotations.SerializedName

data class Region(
    @SerializedName("EnglishName") val EnglishName: String,
    @SerializedName("ID") val id: String,
    @SerializedName("LocalizedName") val localizedName: String
)