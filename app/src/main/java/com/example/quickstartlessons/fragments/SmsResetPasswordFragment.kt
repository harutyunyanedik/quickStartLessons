package com.example.quickstartlessons.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.quickstartlessons.base.BaseFragment
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonResetPasswordSMS.setOnClickListener {
            if (binding.editTextPhoneNumber.text.isBlank()){
                Toast.makeText(requireContext(), "Please enter your number", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), binding.editTextPhoneNumber.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SmsResetPasswordFragment()
    }
}