package com.example.weathercomposeapp.util.Extensions

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationManager
import android.os.Looper.myLooper
import android.util.Log
import androidx.activity.ComponentActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult

fun ComponentActivity.checkLocation(
    fusedLocationProviderClient: FusedLocationProviderClient,
    location: (Double, Double) -> Unit
) {
    val manager =
        getSystemService(Context.LOCATION_SERVICE) as LocationManager
    val isNetworkEnabled = manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    val isGPSEnabled = manager.isProviderEnabled(LocationManager.GPS_PROVIDER)

    if (!isNetworkEnabled || !isGPSEnabled)
        Log.e("TAG", "checkLocation: please enabled GPS")
    else {
        fusedLocationProviderClient.getLocation { latitude, longitude ->
            location(latitude, longitude)
        }
    }
}

@SuppressLint("MissingPermission")
fun FusedLocationProviderClient.getLocation(location: (Double, Double) -> Unit) {
    this.lastLocation.addOnCompleteListener { taskLocation ->
        val locationResult: Location? = taskLocation.result
        locationResult?.let {
            location(it.latitude, it.longitude)
        } ?: this.getNewLocationData {
            location(it.latitude, it.longitude)
        }
    }
}

@SuppressLint("MissingPermission")
fun FusedLocationProviderClient.getNewLocationData(lastLocation: (Location) -> Unit) {
    val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            lastLocation(locationResult.lastLocation)
        }
    }
    val locationRequest = LocationRequest.create().apply {
        priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        interval = 0
        fastestInterval = 0
        numUpdates = 1
    }
    this.requestLocationUpdates(locationRequest, locationCallback, myLooper())
}