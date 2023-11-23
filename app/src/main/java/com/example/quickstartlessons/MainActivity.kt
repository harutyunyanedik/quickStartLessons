package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.android.adapter.RecyclerViewAdapter
import com.example.quickstartlessons.android.model.RvFirstModel

import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.databinding.ItemRecycleViewBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = RecyclerViewAdapter()
    private val listCountry = mutableListOf("London", "Amsterdam", "Berlin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
        adapter.updateData(createNewList())
    }

    private fun createNewList(): List<RvFirstModel> {
        val list = mutableListOf<RvFirstModel>()
        for (j in listCountry) {
            for (i in 1..10) {
                val header = if (i % 2 == 0) "Droidcon " else null
                val standard = if (i % 3 == 0) "Droidcon in  $j" else null
                list.add(RvFirstModel(j, header, standard))

            }
        }
        return list
    }

}