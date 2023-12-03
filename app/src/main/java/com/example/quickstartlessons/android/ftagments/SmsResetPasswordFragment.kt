package com.example.quickstartlessons.android.ftagments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.quickstartlessons.android.base.BaseFragment
import com.example.quickstartlessons.databinding.FragmentSmsResetPasswordBinding

class SmsResetPasswordFragment : BaseFragment() {
private lateinit var binding: FragmentSmsResetPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSmsResetPasswordBinding.inflate(inflater,container,false)
       return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val country = binding.countryNumber.text.toString()
       val num = binding.phoneNumber.text.toString()
        val phoneNum = country + num
        val phoneNumber = "Your phone number is enter"
        binding.sendSms.setOnClickListener{
                Toast.makeText(requireContext(),phoneNumber,Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SmsResetPasswordFragment()
    }
}