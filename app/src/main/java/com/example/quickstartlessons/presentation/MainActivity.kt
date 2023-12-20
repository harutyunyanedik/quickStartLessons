package com.example.quickstartlessons.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MessageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        addFragment(MessageViewPagerFragment.newInstance())

    }

    private fun addFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .add(R.id.activity_container, fragment)
            .addToBackStack(fragment::class.java.simpleName)
            .commit()
    }
}