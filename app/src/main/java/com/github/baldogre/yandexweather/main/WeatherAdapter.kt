package com.github.baldogre.yandexweather.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.baldogre.yandexweather.R
import com.github.baldogre.yandexweather.databinding.WeatherItemBinding
import com.github.baldogre.yandexweather.model.weather.Forecast

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
    var list: List<Forecast> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: WeatherItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.weather_item, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[holder.adapterPosition]
        holder.bind(item)
    }

    fun updateWeatherList(weatherList: List<Forecast>) {
        list = weatherList
    }


    inner class ViewHolder(private val binding: WeatherItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = WeatherItemViewModel()

        fun bind(forecast: Forecast) {
            viewModel.bind(forecast)
            binding.viewModel = viewModel
        }
    }
}
