package com.example.weathercomposeapp.ui.activity

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.ACCESS_COARSE_LOCATION
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.core.content.ContextCompat
import com.example.weathercomposeapp.ui.screens.HomeScreen
import com.example.weathercomposeapp.ui.viewmodel.WeatherViewModel
import com.example.weathercomposeapp.util.checkLocation
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()

    private val requestMultiplePermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            if (permissions[ACCESS_FINE_LOCATION] == true && permissions[ACCESS_COARSE_LOCATION] == true) {
                checkLocation(fusedLocationClient) { latitude, longitude ->
                    //viewModel.getPosition("$latitude,$longitude")
                }
            } else {
                Log.i("TAG", "permission: denied")
            }
        }
    private lateinit var fusedLocationClient: FusedLocationProviderClient


    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        getPermissionsLocation()
        setContent {
            HomeScreen(data = viewModel.dataCurrentCondition, viewModel.city)
        }
    }

    private fun getPermissionsLocation() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED -> {
                Log.i("TAG", "Permission: Granted")
                checkLocation(fusedLocationClient) { latitude, longitude ->
                    //viewModel.getPosition("$latitude,$longitude")
                }
            }
            shouldShowRequestPermissionRationale(ACCESS_FINE_LOCATION) -> {
                Log.i("TAG", "Permission: Show Request Permission")
            }
            else -> requestMultiplePermissionLauncher.launch(
                arrayOf(
                    ACCESS_FINE_LOCATION,
                    ACCESS_COARSE_LOCATION
                )
            )
        }
    }
}