package com.example.quickstartlessons.android.base

import androidx.fragment.app.Fragment
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.extension.mainActivity
import com.example.quickstartlessons.kotlin.lesson2.main

abstract class BaseFragment: Fragment() {
    fun addFragment(fragment: Fragment) {
       mainActivity().addFragment(fragment)
    }

    fun replaceFragment(fragment: Fragment) {
        mainActivity().replaceFragment(fragment)
    }
    fun goBack(){
        mainActivity().popFragment()
    }
}