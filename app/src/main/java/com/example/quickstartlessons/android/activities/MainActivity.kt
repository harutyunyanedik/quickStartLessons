package com.example.quickstartlessons.android.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.adapters.CitiesAdapter
import com.example.quickstartlessons.android.models.CitiesModel
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: CitiesAdapter = CitiesAdapter()
    private val cities: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        createCities()
        setAdapter()
    }

    private fun setAdapter() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.updateData(createModels())

    }

    private fun createModels(): MutableList<CitiesModel> {
        val list = mutableListOf<CitiesModel>()
        for (i in cities) {
            list.add(CitiesModel(i))
            for (j in 0..2) {
                list.add(CitiesModel(title = "Droidcon"))
                list.add(CitiesModel(description = "Droidcon in $i"))
            }
        }
        return list
    }

    private fun createCities() {
        cities.add("London")
        cities.add("Amsterdam")
        cities.add("Berlin")
    }

}