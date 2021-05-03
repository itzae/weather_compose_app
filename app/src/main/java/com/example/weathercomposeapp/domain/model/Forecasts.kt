package com.example.weathercomposeapp.domain.model

import com.example.weathercomposeapp.data.model.DailyForecast
import com.example.weathercomposeapp.util.Extensions.getDateFromEpoch

data class Forecasts(
    val day: String,
    val minTemperature: String,
    val maxTemperature: String,
    val icon: Int
)

fun DailyForecast.toDataForecasts() = Forecasts(
    day = this.epochDate.getDateFromEpoch(),
    minTemperature = this.temperature.minimum.value.toString(),
    maxTemperature = this.temperature.maximum.value.toString(),
    icon = this.day.icon
)