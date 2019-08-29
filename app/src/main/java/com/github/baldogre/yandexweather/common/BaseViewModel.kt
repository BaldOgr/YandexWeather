package com.github.baldogre.yandexweather.common

import android.util.Log
import androidx.lifecycle.ViewModel
import com.github.baldogre.yandexweather.common.di.DaggerViewModelInjector
import com.github.baldogre.yandexweather.main.MainViewModel
import com.github.baldogre.yandexweather.common.di.NetworkModule
import com.github.baldogre.yandexweather.common.di.ViewModelInjector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import retrofit2.Response
import java.io.IOException
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector.builder()
        .networkModule(NetworkModule)
        .build()

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    val scope = CoroutineScope(coroutineContext)

    init {
        inject()
    }

    fun <T : Any> safeApiResult(response: Response<T>, errorMessage: String): Result<T> {
        if (response.isSuccessful) return Result.Success(response.body()!!)

        return Result.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - $errorMessage"))
    }

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
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