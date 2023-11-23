package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.adapter.MultiViewHolderAdapter

import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.fragments.FirstFragment
import com.example.quickstartlessons.model.RecyclerViewModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

supportFragmentManager.beginTransaction().add(R.id.container,FirstFragment.newInstance(),FirstFragment::class.java.simpleName).commit()
    }


}