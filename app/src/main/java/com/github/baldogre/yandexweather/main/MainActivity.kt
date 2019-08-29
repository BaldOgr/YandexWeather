package com.github.baldogre.yandexweather.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.baldogre.yandexweather.R
import com.github.baldogre.yandexweather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.postList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        val spinnerAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        spinnerAdapter.addAll(viewModel.getCities())

        binding.spinner.adapter = spinnerAdapter
//        binding.spinner.onItemSelectedListener = viewModel.getOnItemSelectedListener()
    }
}
