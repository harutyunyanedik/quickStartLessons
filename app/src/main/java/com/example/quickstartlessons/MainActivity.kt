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

   lateinit var binding:ActivityMainBinding
    private  val adapter=RecyclerViewAdapter()
    val listCountry = mutableListOf("London","Amsterdam","Berlin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
         binding.recyclerView.apply {
             layoutManager=LinearLayoutManager(this@MainActivity)
             adapter=this@MainActivity.adapter
         }
        adapter.updateData(createNewList())
    }
    fun createNewList():List<RvFirstModel>{
        val list = mutableListOf<RvFirstModel>()
        for(i in 1..30) {
            for (j in listCountry) {
                val item1=if(i%3==0) " some event" else null
                val item2=if(i%3==0) " some event in $j" else null
                list.add(RvFirstModel(j, "Droidcon",  "Droidcon in $j",item1,item2))
            }
        }
        return list
    }

}