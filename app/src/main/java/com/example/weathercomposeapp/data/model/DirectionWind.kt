package com.example.weathercomposeapp.data.model

import com.google.gson.annotations.SerializedName

data class DirectionWind(
    @SerializedName("Degrees") val degrees: Int,
    @SerializedName("Localized") val localized: String,
    @SerializedName("English") val english: String,
)
