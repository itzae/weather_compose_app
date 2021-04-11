package com.example.weathercomposeapp.data.model

import com.google.gson.annotations.SerializedName

data class AdministrativeArea(
    @SerializedName("CountryID") val countryId: String,
    @SerializedName("EnglishName") val englishName: String,
    @SerializedName("EnglishType") val englishType: String,
    @SerializedName("ID") val id: String,
    @SerializedName("Level") val level: Int,
    @SerializedName("LocalizedName") val localizedName: String,
    @SerializedName("LocalizedType") val localizedType: String
)