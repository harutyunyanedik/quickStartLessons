package com.example.quickstartlessons.android.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.adapters.FirstRecyclerAdapter
import com.example.quickstartlessons.android.models.RvModel
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = FirstRecyclerAdapter()

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        adapter.updateData(createDemoData())
    }

    private fun createDemoData(): List<RvModel> {
        val list = mutableListOf<RvModel>()
        for (i in 0..100) {
            list.add(RvModel("title $i", "description $i"))
        }
        return list
    }
}