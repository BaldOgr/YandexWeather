package com.github.baldogre.yandexweather.model.weather


import com.squareup.moshi.Json

data class Fact(
    @Json(name = "temp")
    val temp: Int,
    @Json(name = "feels_like")
    val feelsLike: Int,
    @Json(name = "icon")
    val icon: String,
    @Json(name = "condition")
    val condition: String,
    @Json(name = "wind_speed")
    val windSpeed: Int,
    @Json(name = "wind_gust")
    val windGust: Double,
    @Json(name = "wind_dir")
    val windDir: String,
    @Json(name = "pressure_mm")
    val pressureMm: Int,
    @Json(name = "pressure_pa")
    val pressurePa: Int,
    @Json(name = "humidity")
    val humidity: Int,
    @Json(name = "uv_index")
    val uvIndex: Int,
    @Json(name = "soil_temp")
    val soilTemp: Int,
    @Json(name = "soil_moisture")
    val soilMoisture: Double,
    @Json(name = "daytime")
    val daytime: String,
    @Json(name = "polar")
    val polar: Boolean,
    @Json(name = "season")
    val season: String,
    @Json(name = "obs_time")
    val obsTime: Int,
    @Json(name = "source")
    val source: String
)