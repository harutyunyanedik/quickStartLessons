package com.example.quickstartlessons.android.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.adapter.ResetPasswordAdapter
import com.example.quickstartlessons.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class ResetPasswordViewPagerFragment : BaseFragment() {
    private lateinit var binding: FragmentViewPagerBinding
    private lateinit var adapter: ResetPasswordAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()

    }

    private fun setupView() {
        adapter = ResetPasswordAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
        binding.viewPager.adapter = adapter
        adapter.updateData(listOf(SmsResetPasswordFragment.newInstance(), MailResetPasswordFragment.newInstance()))
        val fragment = mutableListOf(SmsResetPasswordFragment.newInstance(), MailResetPasswordFragment.newInstance())
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (fragment[position]) {
                is SmsResetPasswordFragment -> tab.text = " SMS "
                is MailResetPasswordFragment -> tab.text = "Email"
            }
        }.attach()
    }

    companion object {
        fun newInstance() = ResetPasswordViewPagerFragment()
    }
}