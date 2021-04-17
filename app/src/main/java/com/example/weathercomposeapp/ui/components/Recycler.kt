package com.example.weathercomposeapp.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weathercomposeapp.domain.model.Forecasts

@Composable
fun ForecastList(modifier: Modifier = Modifier, listData: List<Forecasts>) {
    LazyColumn(modifier = modifier) {
        items(listData) {
            ItemDayCondition(it)
        }
    }
}