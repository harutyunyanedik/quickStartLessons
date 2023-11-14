package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter: ImageAdapter = ImageAdapter(this, createList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = ImageAdapter(this,createList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.updateData(createList())
    }

    private fun createList(): List<ImageModel> {
        val list = mutableListOf<ImageModel>()
        for (i in 0..8) {
            list.add(ImageModel("https://www.monstertreeservice.com/cms/thumbnails/24/1080x540/images/articles/MTS_OUW_WhichTreesLiveTheLongest_BlogPhoto_Jan23.jpg"))
            list.add(ImageModel("https://www.adorama.com/alc/wp-content/uploads/2017/11/shutterstock_114802408-825x465.jpg"))
        }
        return list
    }
}