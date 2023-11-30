package com.example.quickstartlessons.android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.base.BaseFragment
import com.example.quickstartlessons.databinding.FragmentSmsResetPasswordBinding


class SmsResetPasswordFragment : BaseFragment() {

    private lateinit var binding: FragmentSmsResetPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSmsResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = SmsResetPasswordFragment()
    }
}