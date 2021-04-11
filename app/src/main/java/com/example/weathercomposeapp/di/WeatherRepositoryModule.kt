package com.example.weathercomposeapp.di

import com.example.weathercomposeapp.data.network.WeatherApi
import com.example.weathercomposeapp.data.repository.WeatherRepository
import com.example.weathercomposeapp.data.repository.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object WeatherRepositoryModule {
    @Singleton
    @Provides
    fun provideWeatherRepository(
        weatherApi: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(weatherService = weatherApi)
    }
}