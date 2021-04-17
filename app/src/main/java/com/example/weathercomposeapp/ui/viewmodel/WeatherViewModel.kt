package com.example.weathercomposeapp.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathercomposeapp.data.repository.WeatherRepository
import com.example.weathercomposeapp.domain.model.CurrentCondition
import com.example.weathercomposeapp.domain.model.Forecasts
import com.example.weathercomposeapp.domain.model.toCurrentConditionData
import com.example.weathercomposeapp.domain.model.toDataForecasts
import kotlinx.coroutines.launch
import retrofit2.HttpException


class WeatherViewModel @ViewModelInject constructor(private val weatherRepositoryImpl: WeatherRepository) :
    ViewModel() {

    var dataCurrentCondition by mutableStateOf(CurrentCondition())
        private set

    var dataForecasts by mutableStateOf(listOf<Forecasts>())
        private set

    var city by mutableStateOf("")
        private set

    fun getPosition(location: String) {
        viewModelScope.launch {
            try {
                val data = weatherRepositoryImpl.getGeoposition(location)
                val currentConditionData =
                    weatherRepositoryImpl.getCurrentCondition(data.key.toInt())
                val forecastData = weatherRepositoryImpl.getForecasts(data.key.toInt())
                Log.i("TAG", "getPosition: $data")
                dataCurrentCondition =
                    currentConditionData[0].toCurrentConditionData()
                city = data.localizedName
                dataForecasts =
                    forecastData.dailyForecasts.map { forecastsRemote -> forecastsRemote.toDataForecasts() }
            } catch (e: HttpException) {
                Log.e("TAG", "getPosition: Error ${e.code()}")
            }
        }
    }
}