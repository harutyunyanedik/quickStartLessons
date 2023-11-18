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
        for(i in 1..30){
            val header: String? =if(i %3==0) "Some event" else null
            val standard:String?=if(i%3==0) "Some event in London" else null
            list.add(RvFirstModel("London","Droidcon","Droidcon in London",header,standard))
           list.add(RvFirstModel("Amsterdam", "Droidcon", "Droidcon in Amsterdam"))
           list.add(RvFirstModel("Berlin", "Droidcon", "Droidcon in Berlin"))
        }
        return list
    }

}