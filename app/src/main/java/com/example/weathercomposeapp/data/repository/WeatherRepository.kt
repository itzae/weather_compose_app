package com.example.weathercomposeapp.data.repository

import com.example.weathercomposeapp.data.model.CurrentConditionResponse
import com.example.weathercomposeapp.data.model.GeoPositionResponse

interface WeatherRepository {
    suspend fun getGeoposition (location:String):GeoPositionResponse
    suspend fun getCurrentCondition (locationKey:Int) : CurrentConditionResponse
}