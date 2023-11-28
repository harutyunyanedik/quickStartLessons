package com.example.quickstartlessons.android.base

import androidx.fragment.app.Fragment
import com.example.quickstartlessons.MAIN

abstract class BaseFragment: Fragment() {

    fun addFragment(fragment: Fragment) {
        MAIN.addFragment(fragment)
    }

    fun replaceFragment(fragment: Fragment) {
      MAIN.replaceFragment(fragment)
    }

    fun goBack() {
        MAIN.popFragment()
    }
}