package com.example.weathercomposeapp.ui.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun AlertGPS(onConfirm: () -> Unit) {
    AlertDialog(
        title = { Text(text = "¡Hey!") },
        text = { Text(text = "Por favor habilita tu gps") },
        confirmButton = {
            Button(onClick = {
                onConfirm()
            }) {
                Text(text = "Aceptar")
            }
        }, onDismissRequest = {}
    )
}