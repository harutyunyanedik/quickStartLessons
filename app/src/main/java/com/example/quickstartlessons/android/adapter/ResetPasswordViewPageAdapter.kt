package com.example.quickstartlessons.android.adapter

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.quickstartlessons.android.base.BaseFragment

class ResetPasswordViewPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {


    private val fragments: MutableList<BaseFragment> = mutableListOf()

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int) = fragments[position]
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<BaseFragment>?) {
        fragments.clear()
        items?.let { fragments.addAll(it) }
        notifyDataSetChanged()
    }
}