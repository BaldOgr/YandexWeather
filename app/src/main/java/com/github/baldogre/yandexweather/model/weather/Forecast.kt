package com.github.baldogre.yandexweather.model.weather


import com.google.gson.annotations.SerializedName

data class Forecast(
    @SerializedName("date")
    val date: String,
    @SerializedName("date_ts")
    val dateTs: Int,
    @SerializedName("week")
    val week: Int,
    @SerializedName("sunrise")
    val sunrise: String,
    @SerializedName("sunset")
    val sunset: String,
    @SerializedName("rise_begin")
    val riseBegin: String,
    @SerializedName("set_end")
    val setEnd: String,
    @SerializedName("moon_code")
    val moonCode: Int,
    @SerializedName("moon_text")
    val moonText: String,
    @SerializedName("parts")
    val parts: Parts,
    @SerializedName("hours")
    val hours: List<Any>
)