package com.example.weathercomposeapp.data.model

import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    @SerializedName("DailyForecasts") val dailyForecasts: List<DailyForecast>,
    @SerializedName("Headline") val headline: Headline
)