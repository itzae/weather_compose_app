package com.example.weathercomposeapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathercomposeapp.data.model.Wind
import com.example.weathercomposeapp.domain.model.CurrentCondition
import com.example.weathercomposeapp.domain.model.Forecasts
import com.example.weathercomposeapp.ui.theme.WhiteTransparent
import com.example.weathercomposeapp.util.Extensions.getIconForecast
import androidx.compose.foundation.layout.Arrangement as layoutAlignment

@Composable
fun CardCurrentCondition(data: CurrentCondition, cityName: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = layoutAlignment.Center) {
        LabelWithIcon(
            textParam = cityName,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp),
            style = MaterialTheme.typography.subtitle2.copy(color = Color.White)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Image(
                painterResource(id = data.iconId.getIconForecast()),
                contentDescription = " ",
                modifier = Modifier
                    .padding(end = 16.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = "${data.temperature}°",
                style = MaterialTheme.typography.h2.copy(color = Color.White)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = data.weatherText,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.subtitle2.copy(color = Color.White)

        )
        WindSection(data.directionWind, data.speedWind, modifier = Modifier.padding(top = 60.dp))
    }
    Divider(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .border(width = 1.dp, color = WhiteTransparent)
    )

}

@Composable
fun WindSection(directionWind: String, speedWind: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = layoutAlignment.Center
    ) {
        AnimatedImage(
            modifier = Modifier
                .size(100.dp)
                .padding(top = 16.dp)
        )
        Column(verticalArrangement = layoutAlignment.Center) {
            Row(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = "Dirección del viento",
                    style = MaterialTheme.typography.subtitle2.copy(color = WhiteTransparent)
                )
                Text(
                    text = directionWind,
                    modifier = Modifier.padding(start = 16.dp),
                    style = MaterialTheme.typography.subtitle2.copy(color = Color.White)
                )
            }
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Velocidad del viento",
                    style = MaterialTheme.typography.subtitle2.copy(color = WhiteTransparent)
                )
                Text(
                    text = speedWind, modifier = Modifier.padding(start = 16.dp),
                    style = MaterialTheme.typography.subtitle2.copy(color = Color.White)
                )
            }
        }
    }
}

@Composable
fun ItemDayCondition(forecastsData: Forecasts) {

    Row(
        modifier = Modifier
            .padding(top = 16.dp, start = 8.dp, end = 8.dp)
    ) {
        Text(
            text = forecastsData.day,
            style = MaterialTheme.typography.caption.copy(color = Color.White),
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painterResource(id = forecastsData.icon.getIconForecast()),
            contentDescription = "", modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .weight(1f)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "${forecastsData.minTemperature}° / ${forecastsData.maxTemperature}°",
            style = MaterialTheme.typography.caption.copy(color = Color.White),
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            textAlign = TextAlign.End
        )
    }


}

@Preview
@Composable
fun PreviewItemDayCondition() {
    ItemDayCondition(Forecasts("Mar", "27°", "38°", 1))
}

@Preview(name = "CardCurrentCondition")
@Composable
fun PreviewCurrentCondition() {
    CardCurrentCondition(data = CurrentCondition("31"), cityName = "Arcelia")
}