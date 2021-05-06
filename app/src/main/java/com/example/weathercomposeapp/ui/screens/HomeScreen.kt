package com.example.weathercomposeapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathercomposeapp.domain.model.CurrentCondition
import com.example.weathercomposeapp.domain.model.Forecasts
import com.example.weathercomposeapp.ui.components.AlertGPS
import com.example.weathercomposeapp.ui.components.CardCurrentCondition
import com.example.weathercomposeapp.ui.components.ForecastList
import com.example.weathercomposeapp.ui.theme.Purple300
import com.example.weathercomposeapp.ui.theme.SkyColor600
import com.example.weathercomposeapp.ui.theme.WeatherComposeAppTheme


@Composable
fun HomeScreen(
    data: CurrentCondition,
    cityName: String,
    forecastsData: List<Forecasts>,
    isEnabledGps: Boolean,
    onConfirmDialog: (Boolean) -> Unit
) {

    WeatherComposeAppTheme {
        //This validation show alert when the GPS is disabled
        if (!isEnabledGps) AlertGPS {
            onConfirmDialog(true)
        }
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
                    .padding(start = 8.dp, end = 8.dp, top = 16.dp),
                forecastsData
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
    HomeScreen(data = CurrentCondition("38°"), cityName = "Arcelia", listOf(), true,{})
}
