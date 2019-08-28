package com.github.baldogre.yandexweather.model.weather


import com.squareup.moshi.Json

data class Day(
    @Json(name = "_source")
    val source: String,
    @Json(name = "temp_min")
    val tempMin: Int,
    @Json(name = "temp_max")
    val tempMax: Int,
    @Json(name = "temp_avg")
    val tempAvg: Int,
    @Json(name = "feels_like")
    val feelsLike: Int,
    @Json(name = "icon")
    val icon: String,
    @Json(name = "condition")
    val condition: String,
    @Json(name = "daytime")
    val daytime: String,
    @Json(name = "polar")
    val polar: Boolean,
    @Json(name = "wind_speed")
    val windSpeed: Double,
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
    @Json(name = "soil_temp")
    val soilTemp: Int,
    @Json(name = "soil_moisture")
    val soilMoisture: Double,
    @Json(name = "prec_mm")
    val precMm: Int,
    @Json(name = "prec_period")
    val precPeriod: Int,
    @Json(name = "prec_prob")
    val precProb: Int
)