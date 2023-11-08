package com.example.quickstartlessons.android.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.Models
import com.example.quickstartlessons.android.adapter.AdapterRecyclerView
import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.databinding.ItemReciclerViewBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
  //private lateinit var binding1: ItemReciclerViewBinding

    private val adapter = AdapterRecyclerView()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

       // binding1.imageUnchecked.setOnClickListener(){
          //  binding1.imageUnchecked.isClickable
       // }
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.arsenalFCSpecials.adapter = adapter
        binding.arsenalFCSpecials.layoutManager = layoutManager
        adapter.updateData(createDemoData())
    }

    private fun createDemoData(): List<Models> {
        val list = mutableListOf<Models>()
        for (i in 0..10) {
            list.add(Models(resources.getString(R.string.FCSpecials)))
        }
        return list
    }
}



