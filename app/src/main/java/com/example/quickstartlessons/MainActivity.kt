package com.example.quickstartlessons

import android.content.Intent
import android.graphics.ColorSpace
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.android.CountryModel

import com.example.quickstartlessons.android.FirstRecyclerAdapter
import com.example.quickstartlessons.android.Model
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter :FirstRecyclerAdapter = FirstRecyclerAdapter{
        Toast.makeText(this,it.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.recyclerView.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        adapter.updateData(createList())
    }

    private fun createList(): List<Model> {
        val list = mutableListOf<Model>()
        for (i in 0..10) {
            list.add(Model("https://cdn-icons-png.flaticon.com/512/330/330426.png", "Europian Union","3",
                listOf(CountryModel("https://cdn-icons-png.flaticon.com/512/330/330426.png"))
            ))
        }
        return list
    }
}