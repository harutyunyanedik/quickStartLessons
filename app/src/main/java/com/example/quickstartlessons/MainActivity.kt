package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.adapter.MultiViewHolderAdapter

import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.model.RecyclerViewModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter: MultiViewHolderAdapter = MultiViewHolderAdapter()
   private val cities= mutableListOf<String>("Yrevan","Berlin","London")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setAdapter()

    }

    private fun setAdapter() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.updateData(createDemoList())
    }

    private fun createDemoList(): List<RecyclerViewModel> {
        val list = mutableListOf<RecyclerViewModel>()
        for (i in cities) {
            list.add(RecyclerViewModel(i))
            val to = Random.nextInt(0, 3)
            for (j in 0..to) {
                list.add(RecyclerViewModel("Droidcon"))
                list.add(RecyclerViewModel("Droidcon in $i"))
            }
        }
        return list
    }

}