package com.example.quickstartlessons.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.adapters.CitiesAdapter
import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.models.RecyclerViewModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = CitiesAdapter()
    private val cities = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        createCities()
        setAdapter()
    }

    private fun setAdapter() {
        binding.rvMultipleViewHolder.adapter = adapter
        binding.rvMultipleViewHolder.layoutManager = LinearLayoutManager(this)
        adapter.updateAdapter(createModels())
    }

    private fun createModels(): List<RecyclerViewModel> {
        val list = mutableListOf<RecyclerViewModel>()
        for (i in cities) {
            list.add(RecyclerViewModel(i))
            val to = Random.nextInt(0, 3)
            for (j in 0..to) {
                list.add(RecyclerViewModel(title = "Droidcon"))
                list.add(RecyclerViewModel(description = "Droidcon in $i"))
            }
        }
        return list
    }

    private fun createCities() {
        cities.add("Yerevan")
        cities.add("London")
        cities.add("Paris")
        cities.add("Los Angeles")
        cities.add("New York")
        cities.add("Glendale")
        cities.add("Berlin")
    }
}