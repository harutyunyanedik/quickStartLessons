package com.example.quickstartlessons.tablayout

import androidx.fragment.app.Fragment
import com.example.quickstartlessons.MainActivity

open class Base:Fragment() {

  fun replaceFragment(fragment: Fragment){
      mainActivity().replaceFragment(fragment)
  }
  fun addFragment(fragment: Fragment){
      mainActivity().addFragment(fragment )
  }
    fun backStake(){
        mainActivity().popBackStake()
    }

}
fun Fragment.mainActivity() = requireActivity() as MainActivity