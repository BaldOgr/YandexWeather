package com.github.baldogre.yandexweather.model.weather


import com.google.gson.annotations.SerializedName

data class NightShortPart(
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("condition")
    val condition: String,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("wind_gust")
    val windGust: Double,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("pressure_mm")
    val pressureMm: Double,
    @SerializedName("pressure_pa")
    val pressurePa: Double,
    @SerializedName("humidity")
    val humidity: Double,
    @SerializedName("uv_index")
    val uvIndex: Double,
    @SerializedName("soil_temp")
    val soilTemp: Double,
    @SerializedName("soil_moisture")
    val soilMoisture: Double,
    @SerializedName("prec_mm")
    val precMm: Double,
    @SerializedName("prec_prob")
    val precProb: Double
)