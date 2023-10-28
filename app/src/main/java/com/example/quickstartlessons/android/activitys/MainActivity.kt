package com.example.quickstartlessons.android.activitys

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.adapters.FirstRecyclerAdapter
import com.example.quickstartlessons.android.models.RvModels
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter= FirstRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpRecyclerView()

    }
    fun setUpRecyclerView(){
        //val layoutManager = LinearLayoutManager(this)
        val layoutManager = GridLayoutManager(this,4)
        binding.recyclerview.adapter= adapter
        binding.recyclerview.layoutManager = layoutManager
        adapter.updateData(createDemoData())
    }

    fun createDemoData(): List<RvModels> {
        val list = mutableListOf<RvModels>()
        for (i in 0..100){
            list.add(RvModels("title $i","description $i"))
        }
       return list
    }
}