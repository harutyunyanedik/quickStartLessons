package com.example.quickstartlessons.android.activitys
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.adapters.FirstRecyclerAdapter
import com.example.quickstartlessons.android.models.RvModels
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter= FirstRecyclerAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpRecyclerView()
    }
    private fun setUpRecyclerView(){
        //val layoutManager = LinearLayoutManager(this)
        val layoutManager = GridLayoutManager(this,4)
        binding.recyclerview.adapter= adapter
        binding.recyclerview.layoutManager = layoutManager
        adapter.updateData(createDemoData())
    }
    private fun createDemoData(): List<RvModels> {
        val list = mutableListOf<RvModels>()
        for (i in 0..99){
            list.add(RvModels("title $i","description $i"))
        }
       return list
    }
}