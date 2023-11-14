package com.example.quickstartlessons

import android.content.Intent
import android.graphics.ColorSpace
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.adapter.AppRecycleAdapter


import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.model.AppModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = AppRecycleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupRecycleView()

    }

    fun setupRecycleView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this,2)
        adapter.updateData(createDemoData())
    }

    fun createDemoData(): List<AppModel> {
        val list = mutableListOf<AppModel>()
        for (i in 0..10) {
            list.add(AppModel("https://www.google.com/search?q=priroda&sca_esv=582353633&tbm=isch&sxsrf=AM9HkKmAgixPZXLQnonj8r2Sahmf65jB5g:1699990765005&source=lnms&sa=X&ved=2ahUKEwj0kK2Nn8SCAxXbYPEDHZrxCjwQ_AUoAXoECAIQAw&biw=1120&bih=540&dpr=1.65#imgrc=yJ-cGlJD9izx6M"))
            list.add(AppModel("https://www.google.com/search?q=priroda&sca_esv=582353633&tbm=isch&sxsrf=AM9HkKmAgixPZXLQnonj8r2Sahmf65jB5g:1699990765005&source=lnms&sa=X&ved=2ahUKEwj0kK2Nn8SCAxXbYPEDHZrxCjwQ_AUoAXoECAIQAw&biw=1120&bih=540&dpr=1.65#imgrc=Dngtjq6gmcoVnM"))
        }
        return list
    }

}