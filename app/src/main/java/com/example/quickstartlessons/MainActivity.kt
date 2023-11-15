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
        for (i in 0..10) {
            list.add(ImageModel(items[Random.nextInt(1, items.size)]))
        }
        return list
    }


    private fun createImages() {
        items.add("https://img.pikbest.com/origin/08/99/61/20mpIkbEsTV9C.jpg!bwr800")
        items.add("https://images.pexels.com/photos/147411/italy-mountains-dawn-daybreak-147411.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
        items.add("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/1121098-pink-nature-wallpaper-1920x1080-lockscreen.jpg/800px-1121098-pink-nature-wallpaper-1920x1080-lockscreen.jpg?20200908180259")
    }

}
