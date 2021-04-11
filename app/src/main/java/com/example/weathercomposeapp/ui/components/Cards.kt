package com.example.weathercomposeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathercomposeapp.domain.model.CurrentCondition
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
                Text(
                    text = "${data.temperature}°",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.h2.copy(color = Color.White)
                )
                Text(
                    text = data.weatherText,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.subtitle2.copy(color = Color.White)

                )
            }
        }
    }

}

@Composable
fun ItemDayCondition() {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .alpha(0.4f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(text = "Lun")
            Spacer(modifier = Modifier.height(10.dp))
            Icon(imageVector = Icons.Filled.WbSunny, contentDescription = "icon")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "32°/26°")
        }
    }

}

@Composable
fun CardHistoryCondition(modifier: Modifier = Modifier, listData: List<String>) {
    Card(
        modifier = modifier,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(20.dp),
        elevation = 10.dp,
    ) {
        Column(modifier = Modifier.padding(top = 16.dp)) {
            Text(text = "Pronostico de los siguientes 5 días",modifier = Modifier.padding(start = 16.dp))
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow{
                items(listData){
                    ItemDayCondition()
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewItemDayCondition() {
    ItemDayCondition()
}