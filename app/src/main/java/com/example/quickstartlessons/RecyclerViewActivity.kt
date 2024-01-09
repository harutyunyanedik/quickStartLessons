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
    fun createNewList():List<NewParametr>{
        val list= mutableListOf<NewParametr>()
        for (i in 0..100){
            list.add(NewParametr("News $i"," $i" ))
        }
        return list
    }

}