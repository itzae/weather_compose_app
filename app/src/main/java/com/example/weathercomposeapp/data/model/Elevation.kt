package com.example.weathercomposeapp.data.model

import com.google.gson.annotations.SerializedName

data class Elevation(
    @SerializedName("Imperial") val imperial: Imperial,
    @SerializedName("Metric") val metric: Metric
)