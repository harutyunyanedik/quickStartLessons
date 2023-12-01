package com.example.quickstartlessons.android.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentSmsResetPasswordBinding
import com.example.quickstartlessons.databinding.FragmentViewPagerBinding

class SmsResetPasswordFragment : BaseFragment() {
    private lateinit var binding: FragmentSmsResetPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSmsResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editTextPhoneNumber.hint="(XX) XXX-XXX"
       binding.sendSms.setOnClickListener {
           Toast.makeText(requireContext(),"You have received a verification code",Toast.LENGTH_SHORT).show()
       }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SmsResetPasswordFragment()

    }
}