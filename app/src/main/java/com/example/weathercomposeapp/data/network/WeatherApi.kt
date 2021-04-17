package com.example.weathercomposeapp.data.network

import com.example.weathercomposeapp.data.model.CurrentConditionResponse
import com.example.weathercomposeapp.data.model.ForecastResponse
import com.example.weathercomposeapp.data.model.GeoPositionResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {

    /**
     * @param apiKey provided API Key.
     * @param q text to search for. In this case, the text should be a comma-separated lat/lon pair (lat,lon).
     * @param language string indicating the language in which to return the resource.
     * @param details boolean value specifies whether or not to include full details in the response.
     * @param topLevel when toplevel=true, the city with the highest rank will be returned.
     * Large cities have higher rank than the neighborhoods within them, so toplevel=true delivers a
     * more generic location result. (Example: 40.73,-74.00 returns Greenwich Village, NY when
     * toplevel=false. If toplevel=true, the same lat/lon pair will return New York, NY.)
     */
    @GET("/locations/v1/cities/geoposition/search")
    suspend fun getGeoPosition(
        @Query("apikey") apiKey: String,
        @Query("q") location: String,
        @Query("language") language: String = "es",
        @Query("details") details: Boolean = false,
        @Query("toplevel") topLevel: Boolean = false
    ): GeoPositionResponse

    @GET("/currentconditions/v1/{locationKey}")
    suspend fun getCurrentConditions(
        @Path("locationKey") locationKey: Int,
        @Query("apikey") apiKey: String,
        @Query("language") language: String = "es",
        @Query("details") details: Boolean = false,
    ): CurrentConditionResponse

    @GET("/forecasts/v1/daily/5day/{locationKey}")
    suspend fun getForecasts(
        @Path("locationKey") locationKey: Int,
        @Query("apikey") apiKey: String,
        @Query("language") language: String = "es",
        @Query("details") details: Boolean = false,
        @Query("metric") metric: Boolean = true,
    ): ForecastResponse
}