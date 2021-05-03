package com.example.weathercomposeapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import com.example.weathercomposeapp.R
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.rememberLottieAnimationState

@Composable
fun AnimatedImage(modifier: Modifier = Modifier) {
    val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.wind_animation) }
    val animationState = rememberLottieAnimationState(autoPlay = true, repeatCount = Int.MAX_VALUE)
    LottieAnimation(spec = animationSpec, animationState = animationState, modifier = modifier)
}