package com.github.baldogre.yandexweather.main

import androidx.lifecycle.MutableLiveData
import com.github.baldogre.yandexweather.common.BaseViewModel
import com.github.baldogre.yandexweather.model.weather.Forecast

class WeatherItemViewModel : BaseViewModel() {
    private val weatherNight = MutableLiveData<String>()
    private val dayWeather = MutableLiveData<String>()
    private val day = MutableLiveData<String>()


    fun bind(forecast: Forecast) {
        weatherNight.value = "${forecast.parts.night.tempMin}..${forecast.parts.night.tempMax}"
        dayWeather.value = "${forecast.parts.day.tempMin}..${forecast.parts.day.tempMax}"
        day.value = forecast.date
    }

    fun getNightWeather(): MutableLiveData<String> {
        return weatherNight
    }

    fun getDayWeather(): MutableLiveData<String> {
        return dayWeather
    }

    fun getDay(): MutableLiveData<String> {
        return day
    }

}