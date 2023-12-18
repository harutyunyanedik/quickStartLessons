package com.example.quickstartlessons.tablayout

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapterViewPager(fragmentManager: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    val fragment:MutableList<Fragment> = mutableListOf()
    override fun getItemCount(): Int =fragment.size

    override fun createFragment(position: Int): Fragment {
     return fragment[position]
    }
   @SuppressLint("NotifyDataSetChanged")
   fun updateData(items:List<Fragment>?){
      fragment.clear()
      items?.let {
           fragment.addAll(items)
       }
        notifyDataSetChanged()
   }
}