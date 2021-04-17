package com.example.weathercomposeapp.data.model

import com.google.gson.annotations.SerializedName

data class Night(
    @SerializedName("HasPrecipitation" ) val hasPrecipitation: Boolean,
    @SerializedName("Icon") val icon: Int,
    @SerializedName("IconPhrase") val iconPhrase: String
)