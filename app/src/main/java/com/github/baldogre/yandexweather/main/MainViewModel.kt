package com.github.baldogre.yandexweather.main

import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import androidx.lifecycle.MutableLiveData
import com.github.baldogre.yandexweather.common.BaseViewModel
import com.github.baldogre.yandexweather.common.di.WeatherApi
import com.github.baldogre.yandexweather.model.weather.City
import com.github.baldogre.yandexweather.model.weather.WeatherResponse
import com.github.baldogre.yandexweather.model.weather.request.WeatherRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel : BaseViewModel() {
    @Inject
    lateinit var api: WeatherApi
    val adapter = WeatherAdapter()

    private lateinit var subscription: Disposable
    private val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    init {
        loadPosts("Almaty")
    }

    private fun loadPosts(city: String) {
        subscription = api.getWeather(
            mapOf(
                Pair("lat", citiesByCoordinates[city]?.lat.toString()),
                Pair("lon", citiesByCoordinates[city]?.lon.toString())
            )
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { onRetrievePostListSuccess(it) },
                { onRetrievePostListError(it) }
            )
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE

    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE

    }

    private fun onRetrievePostListSuccess(weather: WeatherResponse) {
        adapter.updateWeatherList(weather.forecasts)
        adapter.notifyDataSetChanged()

    }

    private fun onRetrievePostListError(it: Throwable) {
        Log.w("Error!", it)
    }

    fun getLoadingVisibility(): MutableLiveData<Int> {
        return loadingVisibility
    }

    fun getCities(): List<String> {
        return citiesByCoordinates.keys.toList()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
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