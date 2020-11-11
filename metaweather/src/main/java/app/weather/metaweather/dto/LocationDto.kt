package app.weather.metaweather.dto

import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("woeid") val woeid: Int,
    @SerializedName("title") val title: String,
    @SerializedName("location_type") val type: String,
    @SerializedName("latt_long") val latLong: String
)
