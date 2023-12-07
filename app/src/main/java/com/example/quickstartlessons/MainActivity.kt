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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

      addFragment(FragmentPlusButton.newInstance())
        addFragment(FragmentEqualButton.newInstance())
    }
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(R.id.firstFragmentContainer, fragment, fragment::class.java.simpleName).addToBackStack(fragment::class.java.simpleName).commit()
    }
  // private fun addSecondFragment(fragment: Fragment){
  //     supportFragmentManager.beginTransaction().add(R.id.secondFragmentContainer,fragment,fragment::class.java.simpleName).addToBackStack(fragment::class.java.simpleName).commit()
  // }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment::class.java.simpleName).addToBackStack(fragment::class.java.simpleName).commit()
    }

    fun popFragment() {
        supportFragmentManager.popBackStack()
    }

}