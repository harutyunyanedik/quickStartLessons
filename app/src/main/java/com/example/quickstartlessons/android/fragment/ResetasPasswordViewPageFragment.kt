package com.example.quickstartlessons.android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import com.example.quickstartlessons.android.adapter.ResetPasswordViewPageAdapter
import com.example.quickstartlessons.android.base.BaseFragment
import com.example.quickstartlessons.databinding.FragmentViewPageBinding
import com.google.android.material.tabs.TabLayoutMediator

class ResetasPasswordViewPageFragment : BaseFragment() {

    private lateinit var binding: FragmentViewPageBinding
    private lateinit var adapter: ResetPasswordViewPageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        adapter = ResetPasswordViewPageAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
        val fragments= mutableListOf(SmsResetPasswordFragment.newInstance(), EmailResetsPasswordFragment.newInstance())
        binding.veiwPager.apply {
            adapter = this@ResetasPasswordViewPageFragment.adapter
            offscreenPageLimit = fragments.size
            isUserInputEnabled = false
        }
        adapter.updateData(fragments)

        TabLayoutMediator(binding.tabLayout, binding.veiwPager) { tab, position ->
            when (fragments[position]) {
                is SmsResetPasswordFragment -> tab.text = "sms"
                is EmailResetsPasswordFragment -> tab.text = "email"
            }
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ResetasPasswordViewPageFragment()
    }
}