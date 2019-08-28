package com.github.baldogre.yandexweather.common.di

import com.github.baldogre.yandexweather.model.weather.WeatherResponse
import com.github.baldogre.yandexweather.model.weather.request.WeatherRequest
import io.reactivex.Observable
import retrofit2.http.*

interface WeatherApi {

    @FormUrlEncoded
    @GET("/forecast")
    @Headers("X-Yandex-API-Key:43ec4ceb-8856-4e4c-af8e-f183479476b6")
    fun getWeather(@Body request: WeatherRequest): Observable<WeatherResponse>

}
