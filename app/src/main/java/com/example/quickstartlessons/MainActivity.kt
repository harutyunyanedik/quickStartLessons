package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.quickstartlessons.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = AdapterImageRecyclerView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
         setupRecyclerView()

    }
     fun setupRecyclerView(){
         val manager=LinearLayoutManager(this)
         binding.recyclerView.layoutManager=manager
         binding.recyclerView.adapter=adapter
         adapter.updateData(createNewList())
     }
        fun createNewChildList():List<ChildModel>{
        val list = mutableListOf<ChildModel>()
        for(i in 0..30){
            list.add(ChildModel(" jjjjjjjj",false))
            }
            return list
        }
     fun createNewList():List<ImageModel>{
         val list = mutableListOf<ImageModel>()
         for(i in 0..30){

             list.add(ImageModel("https://upload.wikimedia.org/wikipedia/commons/f/f2/Argentina_Flag.png", false, createNewChildList()))
              list.add(ImageModel("https://upload.wikimedia.org/wikipedia/commons/b/bc/Flag_of_India.png",false,createNewChildList()))
             list.add(ImageModel("https://upload.wikimedia.org/wikipedia/commons/e/e7/Flag_of_Armenia.png",false,createNewChildList()))
         }
              return  list
     }

}