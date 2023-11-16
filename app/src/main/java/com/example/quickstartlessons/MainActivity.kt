package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager

import com.example.quickstartlessons.android.ImagesAdapter
import com.example.quickstartlessons.android.Model
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = ImagesAdapter()
    private val imageList = listOf(
        R.drawable.photo1,
        R.drawable.photo2,
        R.drawable.photo3,
        R.drawable.photo4,
    )

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupRecycleView()
    }

    fun setupRecycleView() {
        binding.recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
        binding.recyclerView.adapter = adapter
            adapter.updateData(createList())
    }

    fun createList(): List<Model> {
        val list = mutableListOf<Model>()
            for (i in 0..10) {
                if(index > 3) index = 0
                val model = Model(imageList[index])
                   list.add(model)
                index++
            }
        return list
    }
}