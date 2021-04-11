package com.example.weathercomposeapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

/**
 * Weather Compose app custom Color palette
 */
@Stable
class WeatherColors(
    dayGradient: List<Color>,
    nightGradient: List<Color>,
    sunsetGradient: List<Color>
) {
    var dayGradient by mutableStateOf(dayGradient)
        private set
    var nightGradient by mutableStateOf(nightGradient)
        private set
    var sunsetGradient by mutableStateOf(sunsetGradient)
        private set

    fun update(other: WeatherColors) {
        dayGradient = other.dayGradient
        nightGradient = other.nightGradient
        sunsetGradient = other.sunsetGradient
    }
}


private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ProvideWeatherColors(
    colors: WeatherColors,
    content: @Composable() () -> Unit
) {
    val colorPalette = remember { colors }
    colorPalette.update(colors)
    CompositionLocalProvider( LocalWeatherColors provides colorPalette, content = content)
}

private val LocalWeatherColors = staticCompositionLocalOf<WeatherColors> {
    error("No WeatherColorPalette provided")
}

@Composable
fun WeatherComposeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

