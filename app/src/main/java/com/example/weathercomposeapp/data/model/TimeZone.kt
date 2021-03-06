package com.example.weathercomposeapp.data.model

import com.google.gson.annotations.SerializedName

data class TimeZone(
    @SerializedName("Code") val code: String,
    @SerializedName("GmtOffset") val gmtOffset: Int,
    @SerializedName("IsDaylightSaving") val isDaylightSaving: Boolean,
    @SerializedName("Name") val name: String,
    @SerializedName("NextOffsetChange") val nextOffsetChange: String
)