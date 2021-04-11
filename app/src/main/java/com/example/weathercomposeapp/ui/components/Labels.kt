package com.example.weathercomposeapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun LabelWithIcon(
    textParam: String,
    modifier: Modifier = Modifier,
    style: TextStyle,
    iconColor: Color = Color.White
) {
    Row(modifier = modifier) {
        Text(
            text = if (textParam.isEmpty()) "N/A" else textParam,
            modifier = Modifier
                .padding(end = 8.dp)
                .align(Alignment.CenterVertically),
            style = style
        )
        Icon(
            imageVector = Icons.Filled.LocationOn,
            contentDescription = "Location",
            tint = iconColor,
            modifier = Modifier.size(24.dp)
        )
    }
}