package com.example.quickstartlessons

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickstartlessons.adapter.AdapterImageRecyclerView


import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.model.ImageModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = AdapterImageRecyclerView{
        val intent=Intent(this, ImageActivity::class.java)
        intent.putExtra(EXTRA_IMAGE_URL_KEY,it)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
         setupRecyclerView()
    }
     fun setupRecyclerView(){
         val manager=GridLayoutManager(this,2)
         binding.recyclerView.layoutManager=manager
         binding.recyclerView.adapter=adapter
         adapter.updateData(createNewList())

     }

     fun createNewList():List<ImageModel>{
         val list = mutableListOf<ImageModel>()
         for(i in 0..30){
             list.add(ImageModel("https://upload.wikimedia.org/wikipedia/commons/f/f2/Argentina_Flag.png"))
              list.add(ImageModel("https://upload.wikimedia.org/wikipedia/commons/b/bc/Flag_of_India.png"))
             list.add(ImageModel("https://upload.wikimedia.org/wikipedia/commons/e/e7/Flag_of_Armenia.png"))
         }
              return  list
     }
    companion object{
        const val EXTRA_IMAGE_URL_KEY="extra_image_url"
    }

}