package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.android.fragments.ResetPasswordViewPagerFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        addFragment(ResetPasswordViewPagerFragment.newInstance())
    }
    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment,fragment.javaClass.simpleName).commit()
    }
    fun addFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().add(R.id.container,fragment,fragment.javaClass.simpleName).commit()
    }

}