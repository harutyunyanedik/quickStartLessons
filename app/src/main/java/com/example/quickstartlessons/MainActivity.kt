package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickstartlessons.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter: ImageAdapter = ImageAdapter()
    private val items = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        createImages()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = ImageAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter.updateData(createList())
    }

    private fun createList(): List<ImageModel> {
        val list = mutableListOf<ImageModel>()
        for (i in 0..20) {
            list.add(ImageModel(items[Random.nextInt(0, items.size)]))
        }
        return list
    }


    private fun createImages() {
        items.add("https://i.pinimg.com/564x/a3/b8/11/a3b811159ef5e4c783bea04cc76c94a7.jpg")
        items.add("https://i.pinimg.com/564x/a3/b8/11/a3b811159ef5e4c783bea04cc76c94a7.jpg")
        items.add("https://i.pinimg.com/564x/a3/b8/11/a3b811159ef5e4c783bea04cc76c94a7.jpg")
    }

}
