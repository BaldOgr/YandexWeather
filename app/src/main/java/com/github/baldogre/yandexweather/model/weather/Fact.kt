package com.github.baldogre.yandexweather.model.weather


import com.google.gson.annotations.SerializedName

data class Fact(
    @SerializedName("temp")
    val temp: Int,
    @SerializedName("feels_like")
    val feelsLike: Int,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("condition")
    val condition: String,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("wind_gust")
    val windGust: Double,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("pressure_mm")
    val pressureMm: Int,
    @SerializedName("pressure_pa")
    val pressurePa: Int,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("uv_index")
    val uvIndex: Int,
    @SerializedName("soil_temp")
    val soilTemp: Int,
    @SerializedName("soil_moisture")
    val soilMoisture: Double,
    @SerializedName("daytime")
    val daytime: String,
    @SerializedName("polar")
    val polar: Boolean,
    @SerializedName("season")
    val season: String,
    @SerializedName("obs_time")
    val obsTime: Int,
    @SerializedName("source")
    val source: String
)