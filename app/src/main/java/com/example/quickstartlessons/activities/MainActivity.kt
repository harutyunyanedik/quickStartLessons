package com.example.quickstartlessons.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.fragments.AddFragment
import com.example.quickstartlessons.fragments.CounterFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        addFragment(AddFragment.newInstance(), R.id.container1)
        addFragment(CounterFragment.newInstance(), R.id.container2)
    }

    fun addFragment(fragment: Fragment, container: Int){
        supportFragmentManager.beginTransaction().add(container, fragment, fragment::class.java.simpleName).commit()
    }

    fun replaceFragment(fragment: Fragment, container: Int){
        supportFragmentManager.beginTransaction().replace(container, fragment, fragment::class.java.simpleName).commit()
    }
}