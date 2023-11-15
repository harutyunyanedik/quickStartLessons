package com.example.quickstartlessons


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickstartlessons.adapter.AppRecycleAdapter
import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.model.AppModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = AppRecycleAdapter().
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupRecycleView()
        createDemoData()
    }

    private fun setupRecycleView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this,2)
        adapter.updateData(createDemoData())
    }

    private fun createDemoData(): List<AppModel> {
        val list = mutableListOf<AppModel>()
        for (i in 0..10) {
            list.add(AppModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTD5-__NLkUyWMGGkFvsFMBehz7pBRzXvCKA&usqp=CAU"))
            list.add(AppModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_sXKz1m3JhgPevtKrxiNbAcq7ccJ50TcRJw&usqp=CAU"))
        }
        return list
    }

}