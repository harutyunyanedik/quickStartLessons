package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.adapter.MultiViewHolderAdapter

import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.model.RecyclerViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter: MultiViewHolderAdapter = MultiViewHolderAdapter()
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
        for (i in 0..20) {
            val header = if (i % 3 == 0) "header ${i / 3}" else null
            list.add(RecyclerViewModel("$header"))
            list.add(RecyclerViewModel("Droidcon"))
            list.add(RecyclerViewModel("Droidcon in $i"))
        }
        return list
    }
}