package com.example.weathercomposeapp.data.network

import com.example.weathercomposeapp.data.model.CurrentConditionResponse
import com.example.weathercomposeapp.data.model.ForecastResponse
import com.example.weathercomposeapp.data.model.GeoPositionResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {

    /**
     * Large cities have higher rank than the neighborhoods within them, so toplevel=true delivers a
     * more generic location result. (Example: 40.73,-74.00 returns Greenwich Village, NY when
     * toplevel=false. If toplevel=true, the same lat/lon pair will return New York, NY.)
     * @param apiKey provided API Key.
     * @param q text to search for. In this case, the text should be a comma-separated lat/lon pair (lat,lon).
     * @param language string indicating the language in which to return the resource.
     * @param details boolean value specifies whether or not to include full details in the response.
     * @param topLevel when toplevel=true, the city with the highest rank will be returned.
     * @return [GeoPositionResponse]
     */
    @GET("/locations/v1/cities/geoposition/search")
    suspend fun getGeoPosition(
        @Query("apikey") apiKey: String,
        @Query("q") location: String,
        @Query("language") language: String = "es",
        @Query("details") details: Boolean = false,
        @Query("toplevel") topLevel: Boolean = false
    ): GeoPositionResponse

    /**
     * Returns current conditions data for a specific location. Current conditions searches require
     * a location key. Please use the Locations API to obtain the location key for your desired
     * location. By default, a truncated version of the current conditions data is returned. The
     * full object can be obtained by passing "details=true" into the url string.
     * @param locationKey is the id that identifies the place from which you want to know the current condition
     * @param apiKey provided API Key.
     * @param language string indicating the language in which to return the resource.
     * @param details boolean value specifies whether or not to include full details in the response.
     * @return [CurrentConditionResponse]
     */
    @GET("/currentconditions/v1/{locationKey}")
    suspend fun getCurrentConditions(
        @Path("locationKey") locationKey: Int,
        @Query("apikey") apiKey: String,
        @Query("language") language: String = "es",
        @Query("details") details: Boolean = false,
    ): CurrentConditionResponse

    /**
     * Returns an array of daily forecasts for the next 5 days for a specific location. Forecast
     * searches require a location key. Please use the Locations API to obtain the location key for
     * your desired location. By default, a truncated version of the hourly forecast data is returned.
     * The full object can be obtained by passing "details=true" into the url string.
     * @param locationKey is the id that identifies the place from which you want to know the current condition
     * @param apiKey provided API Key.
     * @param language string indicating the language in which to return the resource.
     * @param details boolean value specifies whether or not to include full details in the response.
     * @param metric boolean value specifies whether or not to display metric values.
     * @return [ForecastResponse]
     */
    @GET("/forecasts/v1/daily/5day/{locationKey}")
    suspend fun getForecasts(
        @Path("locationKey") locationKey: Int,
        @Query("apikey") apiKey: String,
        @Query("language") language: String = "es",
        @Query("details") details: Boolean = false,
        @Query("metric") metric: Boolean = true,
    ): ForecastResponse
}