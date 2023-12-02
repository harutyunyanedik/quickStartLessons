package com.example.quickstartlessons.base

import androidx.fragment.app.Fragment
import com.example.quickstartlessons.extensions.mainActivity

abstract class BaseFragment : Fragment() {

    fun addFragment(fragment: Fragment) {
        mainActivity()?.addFragment(fragment)

    }

    fun replaceFragment(fragment: Fragment) {
        mainActivity()?.replaceFragment(fragment)
    }

    fun goBack() {
        mainActivity()?.popFragment()
    }
}