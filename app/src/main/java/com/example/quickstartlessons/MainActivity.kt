package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.ftagments.FirstFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        addFragments(FirstFragment.newInstance())

    }
fun addFragments(fragment:Fragment){
    supportFragmentManager.beginTransaction().add(R.id.container, fragment,fragment::class.java.simpleName).commit()
}

    fun replaceFragments(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment,fragment::class.java.simpleName) .commit()
    }
}