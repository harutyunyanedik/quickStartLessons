package com.example.quickstartlessons.myapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.ActivityTwo
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val itemsList = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "RecyclerView "

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        customAdapter = CustomAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItems() {
        itemsList.add("Arsenal FC Specials")
        itemsList.add("Arsenal FC Specials")
        itemsList.add("Arsenal FC Specials")
        itemsList.add("Arsenal FC Specials")
        itemsList.add("Arsenal FC Specials")
        itemsList.add("Arsenal FC Specials")
        itemsList.add("Arsenal FC Specials")
        itemsList.add("Arsenal FC Specials")
        itemsList.add("Arsenal FC Specials")
        itemsList.add("Arsenal FC Specials")
        customAdapter.notifyDataSetChanged()
    }
}