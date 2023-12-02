package com.example.quickstartlessons.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.quickstartlessons.base.BaseFragment
import com.example.quickstartlessons.databinding.FragmentEmailResetPasswordBinding

class EmailResetPasswordFragment : BaseFragment() {
    private lateinit var binding: FragmentEmailResetPasswordBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEmailResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.resetPasswordButton.setOnClickListener {
            Toast.makeText(requireContext(), "Check your email", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = EmailResetPasswordFragment()
    }
}