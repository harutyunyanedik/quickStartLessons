package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.quickstartlessons.android.fragment.FragmentEqualButton
import com.example.quickstartlessons.android.fragment.FragmentPlusButton

import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val equalButton=FragmentEqualButton.newInstance()
    private val fragmentPlusButton=FragmentPlusButton.newInstance{
        equalButton.incrementCount()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        addFragment(fragmentPlusButton,R.id.firstFragmentContainer)
        addFragment(equalButton,R.id.equalFragmentContainer)
    }
    private fun addFragment(fragment: Fragment,container:Int) {
        supportFragmentManager.beginTransaction().add(container, fragment, fragment::class.java.simpleName).addToBackStack(fragment::class.java.simpleName).commit()
    }


    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment::class.java.simpleName).addToBackStack(fragment::class.java.simpleName).commit()
    }

    fun popFragment() {
        supportFragmentManager.popBackStack()
    }

}