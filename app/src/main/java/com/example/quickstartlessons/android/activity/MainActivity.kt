package com.example.quickstartlessons.android.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.Models
import com.example.quickstartlessons.android.adapter.AdapterRecyclerView
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter :AdapterRecyclerView = AdapterRecyclerView{
        Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpRecyclerView()
    }
    private fun setUpRecyclerView() {
        binding.arsenalFCSpecials.apply {
            adapter = this@MainActivity.adapter
           layoutManager = LinearLayoutManager(this@MainActivity)
        }
        adapter.updateData(createList())
    }
    private fun createList(): List<Models> {
        val list = mutableListOf<Models>()
        for (i in 0..10) {
            list.add(Models("Arsenal FC Specials",false,false))
        }
        return list
    }
}



