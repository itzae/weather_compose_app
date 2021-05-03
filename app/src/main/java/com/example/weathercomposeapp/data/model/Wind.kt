package com.example.weathercomposeapp.data.model

import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("Direction") val direction: DirectionWind,
    @SerializedName("Speed") val speed: Elevation,
)