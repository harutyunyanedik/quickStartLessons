package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adaptor = AdaptorRecyclerView()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupRecycleView()

        }


    fun setupRecycleView() {
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adaptor
        adaptor.updateData(createData())

    }

     fun createChildData():List<Model>{
         val listChild= mutableListOf<Model>()
         for(i in 0..11){
             listChild.add(Model(false,"MLS",2))
             listChild.add(Model(false,"ULS Championship",3))
         }
         return  listChild
     }
    fun createData(): List<RvModel> {
        val list = mutableListOf<RvModel>()
        for (i in 0..10) {
            list.add(RvModel("https://www.pngall.com/wp-content/uploads/2016/05/Australia-Flag-PNG.png","Australia", 11, false, createChildData()))
            list.add(RvModel("https://icons.iconarchive.com/icons/wikipedia/flags/256/KR-South-Korea-Flag-icon.png","Korea(South)", 12, false,createChildData()))
            list.add(RvModel("https://upload.wikimedia.org/wikipedia/commons/f/f2/Argentina_Flag.png","Argentina", 20, false,createChildData()))
            list.add(RvModel("https://upload.wikimedia.org/wikipedia/commons/0/01/Brazil_flag_300.png","Brazil", 28, false,createChildData()))
            list.add(RvModel("https://upload.wikimedia.org/wikipedia/commons/d/de/Flag_of_the_United_States.png","USA", 20, false,createChildData()))
        }
        return list
    }

}


