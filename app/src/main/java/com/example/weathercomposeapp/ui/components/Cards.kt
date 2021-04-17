package com.example.weathercomposeapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.weathercomposeapp.R
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.animatedVectorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathercomposeapp.domain.model.CurrentCondition
import com.example.weathercomposeapp.domain.model.Forecasts
import com.example.weathercomposeapp.ui.theme.WhiteTransparent
import com.example.weathercomposeapp.util.Extensions.getIconForecast
import androidx.compose.foundation.layout.Arrangement as layoutAlignment

@Composable
fun CardCurrentCondition(data: CurrentCondition, cityName: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(verticalArrangement = layoutAlignment.Center) {

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
                        modifier = Modifier.padding(end = 16.dp)
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
            }
            Divider(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(start = 16.dp, end = 16.dp)
                    .border(width = 1.dp, color = WhiteTransparent)
            )
        }
    }

}

@Composable
fun ItemDayCondition(forecastsData: Forecasts) {

    Row(
        modifier = Modifier
            .padding(top=16.dp,start = 8.dp, end = 8.dp)
    ) {
        Text(
            text = "Lun",
            style = MaterialTheme.typography.caption.copy(color = Color.White),
            modifier = Modifier.weight(1f)
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
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End
        )
    }


}

@Preview
@Composable
fun PreviewItemDayCondition() {
    ItemDayCondition(Forecasts("Mar", "27°", "38°", 1))
}