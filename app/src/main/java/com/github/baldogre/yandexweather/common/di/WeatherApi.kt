package com.github.baldogre.yandexweather.common.di

import com.github.baldogre.yandexweather.model.weather.WeatherResponse
import com.github.baldogre.yandexweather.model.weather.request.WeatherRequest
import io.reactivex.Observable
import retrofit2.http.*

interface WeatherApi {

    @GET("forecast")
    @Headers("X-Yandex-API-Key:43ec4ceb-8856-4e4c-af8e-f183479476b6")
    fun getWeather(
        @QueryMap query: Map<String, String> = mapOf(
            Pair("lat", WeatherRequest.lat.toString()),
            Pair("lon", WeatherRequest.lon.toString())
        )
    ): Observable<WeatherResponse>

}
