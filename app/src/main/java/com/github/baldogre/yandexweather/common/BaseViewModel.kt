package com.github.baldogre.yandexweather.common

import androidx.lifecycle.ViewModel
import com.github.baldogre.yandexweather.DaggerViewModelInjector
import com.github.baldogre.yandexweather.main.MainViewModel
import com.github.baldogre.yandexweather.common.di.NetworkModule
import com.github.baldogre.yandexweather.common.di.ViewModelInjector

abstract class BaseViewModel: ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector.builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is MainViewModel -> injector.inject(this)
        }
    }
}