package com.github.baldogre.yandexweather.model.weather


import com.google.gson.annotations.SerializedName

data class Parts(
    @SerializedName("night")
    val night: DayPart,
    @SerializedName("morning")
    val morning: DayPart,
    @SerializedName("day")
    val day: DayPart,
    @SerializedName("evening")
    val evening: DayPart,
    @SerializedName("day_short")
    val dayShort: DayShortPart,
    @SerializedName("night_short")
    val nightShort: NightShortPart
)