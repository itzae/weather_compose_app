package com.example.weathercomposeapp.util.Extensions

import android.os.Build
import android.view.View
import androidx.activity.ComponentActivity

@Suppress("DEPRECATION")
fun ComponentActivity.fullScreen() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        window.setDecorFitsSystemWindows(false)
    } else {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }
}