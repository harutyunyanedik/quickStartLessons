package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var biding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setRecyclerView()
    }

    private fun setRecyclerView(){
        val adapter = FavoriteItemsAdapter()
        biding.recyclerViewFavoriteItems.adapter = adapter
        biding.recyclerViewFavoriteItems.layoutManager = LinearLayoutManager(this)
        adapter.updateData(setList())


    }
    private fun setList(): List<String>{
        val list = mutableListOf<String>()
        for (i in 1.. 15){
            list.add("Arsenal FC Specials")
        }
        return list
    }
}