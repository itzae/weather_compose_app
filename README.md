
# Weather Compose App
## Overview

This application shows the current condition and the next five days according to the location where you are, in it Jetpack Compose is implemented, the new way to build views on Android

## Screens
<img src="https://user-images.githubusercontent.com/27383308/117344654-3c387a00-ae6b-11eb-8256-1c069451dd33.jpeg" width="200"> 

## Architecture
For this project Clean Architecture was used with the following folders

`ui` Being this folder container of the presentation layer and everything that involves the Android framework

`domain` This folder contains all the business logic of the application

`data` This other folder contains the data sources of the application, in this case it will be a remote source, from an API 

`di` This folder contains all the dependencies that are created in the project

`util` This folder contains all the functionalities and extensions that are used in the project

<img src="https://koenig-media.raywenderlich.com/uploads/2019/06/Android-Clean-Architecture-509x500.png" width="200">

## Libs
* [Retrofit](https://github.com/square/retrofit)
* [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android?hl=es-419)
* [Lottie to Compose](https://github.com/airbnb/lottie/blob/master/android-compose.md)
* [Google Play Services Location](https://developers.google.com/android/guides/setup)  

## API

[AccuWeather APIs](https://developer.accuweather.com/apis)

Note: Create your own password to consume the services, you can do it by registering on the AccuWeather page
