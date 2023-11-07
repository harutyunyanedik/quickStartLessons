package com.example.quickstartlessons

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.quickstartlessons.android.Model
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = AdaptorRecycler{
        Toast.makeText(this,it.toString(),Toast.LENGTH_LONG).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupRecycleView()

    }

  private  fun setupRecycleView() {
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
        adapter.apdateData(createNewList())
    }
        private fun createNewList(): List<RvModel> {
             val list= mutableListOf<RvModel>()
             for(i in 0..100){
                 list.add(RvModel(false,"Arsenal FS Specials",false))

             }
             return list
         }

}