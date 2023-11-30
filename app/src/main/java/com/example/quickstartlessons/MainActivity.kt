package com.example.quickstartlessons

import android.content.Intent
import android.graphics.ColorSpace
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.android.MAIN
import com.example.quickstartlessons.android.fragment.ResetasPasswordViewPageFragment

import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        MAIN=this
        addFragment(ResetasPasswordViewPageFragment.newInstance())

    }

    fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment, fragment::class.java.simpleName)
            .addToBackStack(fragment::class.java.simpleName).commit()
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, fragment::class.java.simpleName)
            .addToBackStack(fragment::class.java.simpleName).commit()
    }

    fun popFragment() {
        supportFragmentManager.popBackStack()
    }


}