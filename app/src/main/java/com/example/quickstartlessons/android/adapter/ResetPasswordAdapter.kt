package com.example.quickstartlessons.android.adapter

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.quickstartlessons.android.fragments.BaseFragment

class ResetPasswordAdapter(fragmentManager:FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    private val items = mutableListOf<BaseFragment>()
    override fun getItemCount(): Int = items.size


    override fun createFragment(position: Int): Fragment {
        return items[position]
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item: List<BaseFragment>?) {
        items.clear()
        item?.let {
            items.addAll(item)
            notifyDataSetChanged()
        }
    }
}