package com.example.weathercomposeapp.domain.model

import com.example.weathercomposeapp.data.model.CurrentConditionResponseItem
import kotlin.math.roundToInt

data class CurrentCondition(
    val temperature: String = "N/A",
    val weatherText: String = "N/A",
    val iconId: Int = 0
)

fun CurrentConditionResponseItem.toCurrentConditionData() = CurrentCondition(
    temperature = this.temperature.metric.value.roundToInt().toString(),
    weatherText = this.weatherText,
    iconId = this.weatherIcon
)