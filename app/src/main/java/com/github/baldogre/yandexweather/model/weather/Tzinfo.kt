package com.github.baldogre.yandexweather.model.weather


import com.google.gson.annotations.SerializedName

data class Tzinfo(
    @SerializedName("name")
    val name: String,
    @SerializedName("abbr")
    val abbr: String,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("dst")
    val dst: Boolean
)