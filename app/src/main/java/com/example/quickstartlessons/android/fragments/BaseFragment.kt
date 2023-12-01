package com.example.quickstartlessons.android.fragments

import androidx.fragment.app.Fragment
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.mainActivity

abstract class BaseFragment:Fragment() {
    fun replaceFragment(fragment: Fragment){
  mainActivity().replaceFragment(fragment)
    }
    fun addFragment(fragment: Fragment){
       mainActivity().addFragment(fragment )
    }

}
