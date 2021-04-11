package com.example.weathercomposeapp.data.model

import com.google.gson.annotations.SerializedName

data class Metric(
    @SerializedName("Unit") val unit: String,
    @SerializedName("UnitType") val unitType: Double,
    @SerializedName("Value") val value: Double
)