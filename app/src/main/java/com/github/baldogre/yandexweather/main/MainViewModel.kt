package com.github.baldogre.yandexweather.main

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.github.baldogre.yandexweather.common.BaseViewModel
import com.github.baldogre.yandexweather.common.di.WeatherApi
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
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    init {
        loadPosts()
    }

    private fun loadPosts() {
        subscription = api.getWeather(WeatherRequest(43.227144, 76.880252))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { onRetrievePostListSuccess(it) },
                { onRetrievePostListError() }
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

    private fun onRetrievePostListError() {

    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}