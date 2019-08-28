package com.github.baldogre.yandexweather.model.weather


import com.squareup.moshi.Json

data class WeatherResponse(
    @Json(name = "now")
    val now: Int,
    @Json(name = "now_dt")
    val nowDt: String,
    @Json(name = "info")
    val info: Info,
    @Json(name = "fact")
    val fact: Fact,
    @Json(name = "forecasts")
    val forecasts: List<Forecast>
)