package com.example.quickstartlessons.tablayout

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentAlbumsBinding
import com.example.quickstartlessons.databinding.FragmentBaseBinding
import com.google.android.material.tabs.TabLayoutMediator

class BaseFragmentView : Fragment() {
    private lateinit var binding:FragmentBaseBinding
    private lateinit var adapter:AdapterViewPager
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding=FragmentBaseBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun setupView() {
        adapter = AdapterViewPager(childFragmentManager, viewLifecycleOwner.lifecycle)
        binding.viewPager.adapter = adapter
       val fragment = mutableListOf(FragmentFirst.newInstance(),FragmentSecond.newInstance())
        TabLayoutMediator(binding.tabLayout,binding.viewPager ){ tab, position->
            when(fragment[position]) {
                is FragmentFirst-> tab.text = "մմմմ"
                is FragmentSecond -> tab.text = "ննննն "
            }
        }.attach()
    }

}