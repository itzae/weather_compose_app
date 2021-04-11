package com.example.weathercomposeapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathercomposeapp.domain.model.CurrentCondition
import com.example.weathercomposeapp.ui.components.CardCurrentCondition
import com.example.weathercomposeapp.ui.components.CardHistoryCondition
import com.example.weathercomposeapp.ui.components.ItemDayCondition
import com.example.weathercomposeapp.ui.theme.*


@Composable
fun HomeScreen(data: CurrentCondition, cityName: String) {
    val listData = listOf(
        "Uno",
        "Dos",
        "Tres",
        "Cuatro",
        "Uno",
        "Dos",
        "Tres",
        "Cuatro",
        "Uno",
        "Dos",
        "Tres",
        "Cuatro",
        "Uno",
        "Dos",
        "Tres",
        "Cuatro",
        "Uno",
        "Dos",
        "Tres",
        "Cuatro",
        "Uno",
        "Dos",
        "Tres",
        "Cuatro",
        "Uno",
        "Dos",
        "Tres",
        "Cuatro"

    )


    WeatherComposeAppTheme {
        // A surface container using the 'background' color from the theme
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                Brush.verticalGradient(
                    listOf(
                        SkyColor600,
                        SkyColor200
                    )
                )
            )
        ) {
            CardCurrentCondition(
                data = data,
                cityName = cityName,
                Modifier
                    .fillMaxWidth()
                    .weight(2f)

            )
            CardHistoryCondition(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                listData
            )
        }
    }

}

@Preview
@Composable
fun PreviewCard() {
    CardCurrentCondition(data = CurrentCondition("38°"), cityName = "Arcelia")
}

@Preview
@Composable
fun PreviewScreen() {
    HomeScreen(data = CurrentCondition("38°"), cityName = "Arcelia")
}
