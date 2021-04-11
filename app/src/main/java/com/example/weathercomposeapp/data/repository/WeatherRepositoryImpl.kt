package com.example.weathercomposeapp.data.repository

import com.example.weathercomposeapp.BuildConfig
import com.example.weathercomposeapp.data.model.CurrentConditionResponse
import com.example.weathercomposeapp.data.model.GeoPositionResponse
import com.example.weathercomposeapp.data.network.WeatherApi

class WeatherRepositoryImpl(private val weatherService: WeatherApi) : WeatherRepository {

    override suspend fun getGeoposition(location: String): GeoPositionResponse {
        return weatherService.getGeoPosition(BuildConfig.API_KEY, location)
    }

    override suspend fun getCurrentCondition(locationKey: Int): CurrentConditionResponse =
        weatherService.getCurrentConditions(locationKey, BuildConfig.API_KEY,"es")
}