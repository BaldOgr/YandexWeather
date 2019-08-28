package com.github.baldogre.yandexweather.main

import androidx.lifecycle.MutableLiveData
import com.github.baldogre.yandexweather.common.BaseViewModel
import com.github.baldogre.yandexweather.model.weather.Forecast

class WeatherItemViewModel: BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()


    fun bind(forecast: Forecast) {

    }

}