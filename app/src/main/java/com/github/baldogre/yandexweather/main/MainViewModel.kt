package com.github.baldogre.yandexweather.main

import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.MutableLiveData
import com.github.baldogre.yandexweather.common.BaseViewModel
import com.github.baldogre.yandexweather.common.di.WeatherApi
import com.github.baldogre.yandexweather.model.weather.City
import com.github.baldogre.yandexweather.model.weather.WeatherResponse
import com.github.baldogre.yandexweather.common.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel : BaseViewModel() {
    @Inject
    lateinit var api: WeatherApi
    val adapter = WeatherAdapter()

    private val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    init {
        loadPosts("Almaty")
    }

    private fun loadPosts(city: String) {
        val subscription = api.getWeather(
            mapOf(
                Pair("lat", citiesByCoordinates[city]?.lat.toString()),
                Pair("lon", citiesByCoordinates[city]?.lon.toString())
            )
        )

        onRetrieveWeatherStart()

        scope.launch {
            val response = subscription.await()
            val safeApiResult = safeApiResult(response, "Error")
            GlobalScope.launch {
                withContext(Dispatchers.Main) {
                    when (safeApiResult) {
                        is Result.Success -> {
                            onRetrieveWeatherSuccess(safeApiResult.data)
                        }
                        is Result.Error -> {
                            onRetrieveWeatherError(safeApiResult.exception)
                            Log.d("MainViewModel", "Exception - ${safeApiResult.exception}")
                        }
                    }
                    onRetrieveWeatherFinish()
                }
            }

        }
    }

    private fun onRetrieveWeatherStart() {
        loadingVisibility.value = View.VISIBLE

    }

    private fun onRetrieveWeatherFinish() {
        loadingVisibility.value = View.GONE

    }

    private fun onRetrieveWeatherSuccess(weather: WeatherResponse) {
        adapter.updateWeatherList(weather.forecasts)
        adapter.notifyDataSetChanged()

    }

    private fun onRetrieveWeatherError(it: Throwable) {
        Log.w("Error!", it)
    }

    fun getLoadingVisibility(): MutableLiveData<Int> {
        return loadingVisibility
    }

    fun getCities(): List<String> {
        return citiesByCoordinates.keys.toList()
    }

    fun getOnItemSelectedListener(): AdapterView.OnItemSelectedListener? {
        return object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val city = parent?.adapter?.getItem(position) as String
                loadPosts(city)
            }
        }
    }

    companion object {
        val citiesByCoordinates = mapOf(
            Pair("Almaty", City(43.227144, 76.880252)),
            Pair("Astana", City(51.151756, 71.463939)),
            Pair("Karagandy", City(49.806294, 73.100527))
        )
    }
}