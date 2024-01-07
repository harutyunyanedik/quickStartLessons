package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.module.FirstFragment
import com.example.quickstartlessons.module.SecondFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val liveData = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        liveData.value = "Hello world"
        supportFragmentManager.beginTransaction().add(R.id.container1, FirstFragment.newInstance()).commit()
        supportFragmentManager.beginTransaction().add(R.id.container2, SecondFragment.newInstance()).commit()

    }
}