package com.example.quickstartlessons.android.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentMailResetPasswordBinding

class MailResetPasswordFragment : BaseFragment() {
    private lateinit var binding: FragmentMailResetPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMailResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editTextEmail.hint = "sample@email.com"
        binding.resetPassword.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "You have received a verification code by email",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MailResetPasswordFragment()

    }
}