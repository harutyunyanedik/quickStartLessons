package com.example.quickstartlessons.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quickstartlessons.adapters.ResetPasswordViewPagerAdapter
import com.example.quickstartlessons.databinding.FragmentResetPasswordViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class ResetPasswordViewPagerFragment : Fragment() {
    private lateinit var binding: FragmentResetPasswordViewPagerBinding
    private lateinit var adapter: ResetPasswordViewPagerAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentResetPasswordViewPagerBinding.inflate(inflater, container, false)
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