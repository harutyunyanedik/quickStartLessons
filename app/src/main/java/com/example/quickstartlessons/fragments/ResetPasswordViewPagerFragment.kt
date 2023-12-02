package com.example.quickstartlessons.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.adapters.ResetPasswordViewPagerAdapter
import com.example.quickstartlessons.base.BaseFragment
import com.example.quickstartlessons.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator


class ResetPasswordViewPagerFragment : BaseFragment() {
    private lateinit var binding: FragmentViewPagerBinding
    private lateinit var adapter: ResetPasswordViewPagerAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        adapter = ResetPasswordViewPagerAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
        binding.viewPager.adapter = adapter
        val fragments = mutableListOf(EmailResetPasswordFragment.newInstance(), SmsResetPasswordFragment.newInstance())
        adapter.updateData(fragments)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (fragments[position]) {
                is EmailResetPasswordFragment -> tab.text = "Email"
                is SmsResetPasswordFragment -> tab.text = "SMS"
            }
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ResetPasswordViewPagerFragment()
    }
}