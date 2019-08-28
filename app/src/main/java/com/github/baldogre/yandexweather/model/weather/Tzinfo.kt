package com.github.baldogre.yandexweather.model.weather


import com.squareup.moshi.Json

data class Tzinfo(
    @Json(name = "name")
    val name: String,
    @Json(name = "abbr")
    val abbr: String,
    @Json(name = "offset")
    val offset: Int,
    @Json(name = "dst")
    val dst: Boolean
)