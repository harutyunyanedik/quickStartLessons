package com.example.quickstartlessons.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.ShopItem
import com.example.quickstartlessons.adapters.ShopItemAdapter
import com.example.quickstartlessons.databinding.ActivityShoppingListBinding

class ShopListActivity : AppCompatActivity() {
    lateinit var biding: ActivityShoppingListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = DataBindingUtil.setContentView(this, R.layout.activity_shopping_list)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        val adapter = ShopItemAdapter()
        biding.recyclerViewShopList.adapter = adapter
        biding.recyclerViewShopList.layoutManager = LinearLayoutManager(this)
        adapter.updateData(createDemoData())
    }

    private fun createDemoData(): List<ShopItem>{
        val list = mutableListOf<ShopItem>()
        for (i in 1 .. 100){
            list.add(ShopItem("Name $i", i))
        }
        return list
    }

}