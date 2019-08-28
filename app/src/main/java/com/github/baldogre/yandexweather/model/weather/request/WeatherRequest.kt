package com.github.baldogre.yandexweather.model.weather.request

data class WeatherRequest(val lat: Double = Companion.lat, val lon: Double = Companion.lon) {
    companion object {
        val lat = 43.227144
        val lon = 76.880252
    }
}