package com.example.quickstartlessons.activites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.adapters.GalleryAdapter
import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.models.ImageModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = GalleryAdapter()
    private val images = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        createImages()
        setupAdapter()
    }

    private fun setupAdapter(){
        binding.recyclerviewGallery.adapter = adapter
        binding.recyclerviewGallery.layoutManager = GridLayoutManager(this, 2)
        adapter.updateAdapter(createGallery())
    }

    private fun createGallery(): List<ImageModel> {
        val list = mutableListOf<ImageModel>()
        for (i in 0..100){
            list.add(ImageModel(images[Random.nextInt(0, images.size)]))
        }
        return list
    }

    private fun createImages(){
        images.add("https://media.istockphoto.com/id/1317323736/ru/%D1%84%D0%BE%D1%82%D0%BE/%D0%B2%D0%B8%D0%B4-%D0%BD%D0%B0-%D0%BD%D0%B5%D0%B1%D0%BE-%D0%BD%D0%B0%D0%BF%D1%80%D0%B0%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B4%D0%B5%D1%80%D0%B5%D0%B2%D1%8C%D0%B5%D0%B2.webp?b=1&s=612x612&w=0&k=20&c=eH48yZPJZRbXkaNpeKJ5xaLcws-oeas3Ox1nppvbAWU=")
        images.add("https://media.istockphoto.com/id/1419410282/ru/%D1%84%D0%BE%D1%82%D0%BE/%D1%82%D0%B8%D1%85%D0%B8%D0%B9-%D0%BB%D0%B5%D1%81-%D0%B2%D0%B5%D1%81%D0%BD%D0%BE%D0%B9-%D1%81-%D0%BA%D1%80%D0%B0%D1%81%D0%B8%D0%B2%D1%8B%D0%BC%D0%B8-%D1%8F%D1%80%D0%BA%D0%B8%D0%BC%D0%B8-%D1%81%D0%BE%D0%BB%D0%BD%D0%B5%D1%87%D0%BD%D1%8B%D0%BC%D0%B8-%D0%BB%D1%83%D1%87%D0%B0%D0%BC%D0%B8.webp?b=1&s=612x612&w=0&k=20&c=1VQRym_oRmdiwbwDg-ZgJ5DVRxMHpApVP_D55VymSFU=")
        images.add("https://cdn.pixabay.com/photo/2013/07/18/20/26/sea-164989_1280.jpg")
        images.add("https://cdn.pixabay.com/photo/2015/06/19/21/24/avenue-815297_1280.jpg")
        images.add("https://cdn.pixabay.com/photo/2017/12/15/13/51/polynesia-3021072_1280.jpg")
        images.add("https://cdn.pixabay.com/photo/2014/08/15/11/29/beach-418742_1280.jpg")
        images.add("https://cdn.pixabay.com/photo/2016/10/18/21/22/beach-1751455_1280.jpg")
        images.add("https://cdn.pixabay.com/photo/2018/04/16/16/16/sunset-3325080_1280.jpg")
        images.add("https://cdn.pixabay.com/photo/2018/04/06/00/25/trees-3294681_1280.jpg")
        images.add("https://cdn.pixabay.com/photo/2016/09/07/11/37/sunset-1651426_1280.jpg")
    }
}