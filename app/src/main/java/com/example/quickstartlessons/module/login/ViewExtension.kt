package com.example.quickstartlessons.module.login

import androidx.fragment.app.Fragment
import com.example.quickstartlessons.MainActivity

abstract class ViewExtension :Fragment(){
    fun Fragment.mainActivity() = requireActivity() as MainActivity
}