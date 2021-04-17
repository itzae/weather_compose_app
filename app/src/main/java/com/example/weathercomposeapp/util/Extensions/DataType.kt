package com.example.weathercomposeapp.util.Extensions

import com.example.weathercomposeapp.R

fun Int.getIconForecast(): Int =
    when (this) {
        1 -> R.drawable.ic_sunny
        2, 3, 4, 5, 6 -> R.drawable.ic_mostly_sunny
        7 -> R.drawable.ic_cloud
        8, 11 -> R.drawable.ic_broken_clouds_day
        12, 13, 14, 18 -> R.drawable.ic_shower_rain_day
        15,16,17 -> R.drawable.ic_thunderstorm_day
        24, 25, 26, 29 -> R.drawable.ic_snow_day
        else -> R.drawable.ic_cloud
    }