package com.github.baldogre.yandexweather.model.weather


import com.squareup.moshi.Json

data class Forecast(
    @Json(name = "date")
    val date: String,
    @Json(name = "date_ts")
    val dateTs: Int,
    @Json(name = "week")
    val week: Int,
    @Json(name = "sunrise")
    val sunrise: String,
    @Json(name = "sunset")
    val sunset: String,
    @Json(name = "rise_begin")
    val riseBegin: String,
    @Json(name = "set_end")
    val setEnd: String,
    @Json(name = "moon_code")
    val moonCode: Int,
    @Json(name = "moon_text")
    val moonText: String,
    @Json(name = "parts")
    val parts: Parts,
    @Json(name = "hours")
    val hours: List<Any>
)