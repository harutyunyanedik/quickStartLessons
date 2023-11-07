package com.example.quickstartlessons

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.android.ActivityTwo
import com.example.quickstartlessons.android.FirstRecyclerAdapter
import com.example.quickstartlessons.android.Model
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = FirstRecyclerAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupRecycleView()
    }

    fun setupRecycleView() {
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        adapter.updateData(createData())
    }

    fun createData(): List<Model> {
        val list = mutableListOf<Model>()
        for (i in 0..100) {
            list.add(Model("Arsenal FS Specials"))
        }
        return list
    }
}