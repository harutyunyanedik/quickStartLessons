package com.example.quickstartlessons.android.base

import androidx.fragment.app.Fragment
import com.example.quickstartlessons.android.extensions.mainActivity

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