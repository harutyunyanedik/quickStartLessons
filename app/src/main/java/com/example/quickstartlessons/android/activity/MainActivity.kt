package com.example.quickstartlessons.android.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R

import com.example.quickstartlessons.android.adapter.MultyViewAdapter
import com.example.quickstartlessons.android.Model
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter: MultyViewAdapter = MultyViewAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerView.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
adapter.updateData(createDemoList())
    }

    fun createDemoList(): List<Model> {
        val list:MutableList<Model> = mutableListOf()
        for (i in 0..11) {
            val header:String? = when(i){
                0 ->  "London"
                5 -> "Amsterdam"
                8 -> "Berlin"
                else -> null
            }

            val textHeader:String? = when(i){
                1,6,9 -> "Droidcon"
                3 -> "Some event"
                else -> null
            }

            val title:String = when(i) {
                2 ->"Droidcon in London"
                4->"Some event in London"
                7->"Droidcon in Amsterdam"
                10->"Droidcon in Berlin"
                else-> "Droidcon in "
            }
                        list.add(Model( header,textHeader,title))
            }
        return list
    }

}