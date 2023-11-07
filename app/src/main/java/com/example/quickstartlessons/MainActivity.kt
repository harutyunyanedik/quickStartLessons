package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var biding: ActivityMainBinding
    private lateinit var adapter: FavoriteItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapter = FavoriteItemsAdapter()
        biding.recyclerViewFavoriteItems.adapter = adapter
        setRecyclerView()
    }

    private fun setRecyclerView(){
        biding.recyclerViewFavoriteItems.layoutManager = LinearLayoutManager(this)
        adapter.updateData(setList())

    }
    private fun setList(): List<FavoriteItemModel>{
        val list = mutableListOf<FavoriteItemModel>()
        for (i in 1.. 100){
            list.add(FavoriteItemModel("Arsenal FC Specials", false))
        }
        return list
    }
}