package com.example.weathercomposeapp.data.model

import com.google.gson.annotations.SerializedName

data class GeoPositionResponse(
    @SerializedName("AdministrativeArea") val AdministrativeArea: AdministrativeArea,
    @SerializedName("Country") val country: Country,
    @SerializedName("DataSets") val dataSets: List<String>,
    @SerializedName("EnglishName") val englishName: String,
    @SerializedName("GeoPosition") val geoPosition: GeoPosition,
    @SerializedName("IsAlias") val isAlias: Boolean,
    @SerializedName("Key") val key: String,
    @SerializedName("LocalizedName") val localizedName: String,
    @SerializedName("PrimaryPostalCode") val primaryPostalCode: String,
    @SerializedName("Rank") val rank: Int,
    @SerializedName("Region") val region: Region,
    @SerializedName("SupplementalAdminAreas") val supplementalAdminAreas: List<Any>,
    @SerializedName("TimeZone") val timeZone: TimeZone,
    @SerializedName("Type") val type: String,
    @SerializedName("Version") val version: Int
)