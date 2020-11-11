package app.weather.metaweather.api

import app.weather.metaweather.dto.LocationDto
import app.weather.metaweather.dto.WeatherResponseDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {
    @GET("search")
    fun search(@Query("query") query: String): Call<List<LocationDto>>

    @GET("{locationId}")
    fun location(@Path("locationId") locationId: Int): Call<WeatherResponseDto>
}
