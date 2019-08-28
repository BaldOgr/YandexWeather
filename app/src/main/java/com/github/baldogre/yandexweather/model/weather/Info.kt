package com.github.baldogre.yandexweather.model.weather


import com.squareup.moshi.Json

data class Info(
    @Json(name = "f")
    val f: Boolean,
    @Json(name = "n")
    val n: Boolean,
    @Json(name = "nr")
    val nr: Boolean,
    @Json(name = "ns")
    val ns: Boolean,
    @Json(name = "nsr")
    val nsr: Boolean,
    @Json(name = "p")
    val p: Boolean,
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lon")
    val lon: Double,
    @Json(name = "tzinfo")
    val tzinfo: Tzinfo,
    @Json(name = "def_pressure_mm")
    val defPressureMm: Int,
    @Json(name = "def_pressure_pa")
    val defPressurePa: Int,
    @Json(name = "_h")
    val h: Boolean,
    @Json(name = "url")
    val url: String
)