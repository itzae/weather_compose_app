package com.example.weathercomposeapp.domain.model

import com.example.weathercomposeapp.data.model.DailyForecast

data class Forecasts(
    val day: String,
    val minTemperature: String,
    val maxTemperature: String,
    val icon: Int
)

fun DailyForecast.toDataForecasts() = Forecasts(
    day = this.epochDate.toString(),
    minTemperature = this.temperature.minimum.value.toString(),
    maxTemperature = this.temperature.maximum.value.toString(),
    icon = this.day.icon
)