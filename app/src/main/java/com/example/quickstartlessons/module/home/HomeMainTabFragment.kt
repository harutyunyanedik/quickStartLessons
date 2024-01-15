package com.example.quickstartlessons.module.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ItemHomeMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment

class HomeMainTabFragment : BaseFragment() {
  private lateinit var binding:ItemHomeMainTabBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_home_main_tab, container, false)
    }
}