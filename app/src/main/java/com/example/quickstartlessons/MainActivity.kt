package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.adapters.CountryAdapter
import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.models.ChildModel
import com.example.quickstartlessons.models.CountryModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter: CountryAdapter = CountryAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        binding.parentRecyclerView.adapter = adapter
        binding.parentRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter.updateData(createList())
    }

    private fun createList(): List<CountryModel> {
        val list = mutableListOf<CountryModel>()
        for (i in 0..20) {
            list.add(CountryModel("USA", "https://upload.wikimedia.org/wikipedia/commons/b/bc/Flag_of_the_United_States_%281795-1818%29.jpg", listOf(ChildModel("MLS",false))))
        }
        return list
    }

}