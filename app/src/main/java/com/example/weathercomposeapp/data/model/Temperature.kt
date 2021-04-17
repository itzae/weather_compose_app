package com.example.weathercomposeapp.data.model

import com.google.gson.annotations.SerializedName

data class Temperature(
    @SerializedName("Maximum") val maximum: Metric,
    @SerializedName("Minimum") val minimum: Metric
)