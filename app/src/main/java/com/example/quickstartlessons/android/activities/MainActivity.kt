package com.example.quickstartlessons.android.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.adapters.MultiViewHolderAdapter
import com.example.quickstartlessons.android.models.ModelStandard
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: MultiViewHolderAdapter = MultiViewHolderAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        adapter.updateData(createDemoList())
    }

    private fun createDemoList(): List<ModelStandard> {
        val list = mutableListOf<ModelStandard>()

        for (i in 0..20) {
            val header = if (i % 3 == 0) "header ${i / 3}" else null
            list.add(ModelStandard("title $i", header))
        }
        return list
    }



}