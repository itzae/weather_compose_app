package com.example.weathercomposeapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathercomposeapp.domain.model.CurrentCondition
import com.example.weathercomposeapp.domain.model.Forecasts
import com.example.weathercomposeapp.ui.components.CardCurrentCondition
import com.example.weathercomposeapp.ui.components.ForecastList
import com.example.weathercomposeapp.ui.theme.Purple300
import com.example.weathercomposeapp.ui.theme.SkyColor600
import com.example.weathercomposeapp.ui.theme.WeatherComposeAppTheme


@Composable
fun HomeScreen(data: CurrentCondition, cityName: String, forecastsData: List<Forecasts>) {
    val listForecast = listOf(
        Forecasts("Lun", "31", "38", 2),
        Forecasts("Lun", "31", "38", 2),
        Forecasts("Lun", "31", "38", 2),
        Forecasts("Lun", "31", "38", 2),
        Forecasts("Lun", "31", "38", 2)
    )
    WeatherComposeAppTheme {
        // A surface container using the 'background' color from the theme

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Purple300,
                            SkyColor600
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
            ForecastList(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 8.dp, end = 8.dp,top = 16.dp),
                listForecast
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
    HomeScreen(data = CurrentCondition("38°"), cityName = "Arcelia", listOf())
}
