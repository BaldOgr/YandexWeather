package com.github.baldogre.yandexweather.model.weather


import com.squareup.moshi.Json

data class Parts(
    @Json(name = "night")
    val night: Night,
    @Json(name = "morning")
    val morning: Morning,
    @Json(name = "day")
    val day: Day,
    @Json(name = "evening")
    val evening: Evening,
    @Json(name = "day_short")
    val dayShort: DayShort,
    @Json(name = "night_short")
    val nightShort: NightShort
)