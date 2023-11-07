package com.example.quickstartlessons

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.quickstartlessons.databinding.RecyclerViewBinding



class RecyclerViewActivity : AppCompatActivity() {
    lateinit var binding:RecyclerViewBinding
    private val adaptor=RecyclerAdaptor()
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.recycler_view)
            setupRecyclerView()
    }

        fun setupRecyclerView(){
            val manager= LinearLayoutManager(this)
            binding.recyclerView.adapter=adaptor
            binding.recyclerView.layoutManager=manager
            adaptor.itemData(createNewList())
        }
    fun createNewList():List<newParametr>{
        val list= mutableListOf<newParametr>()
        for (i in 0..100){
            list.add(newParametr("News $i"," $i" ))
        }
        return list
    }

}