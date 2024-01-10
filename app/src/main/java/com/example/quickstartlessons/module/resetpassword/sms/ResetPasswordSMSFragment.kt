package com.example.quickstartlessons.module.resetpassword.sms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentResetPasswordSMSBinding

class ResetPasswordSMSFragment : Fragment() {

    private lateinit var binding: FragmentResetPasswordSMSBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResetPasswordSMSBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.getSmc.doAfterTextChanged {
            binding.buttonResetPassword.isEnabled = !it.isNullOrEmpty() && !binding.getSmc.text.isNullOrEmpty()
        }

        binding.getSmc.doOnTextChanged { text, start, before, count ->
            if (text!!.length != 8) {
                binding.getSmcLayout.error = "Must contain 8 Character!"
            } else {
                binding.getSmcLayout.error = null
            }
        }

        binding.buttonResetPassword.setOnClickListener {

        }
    }

    companion object {
        fun newInstance() = ResetPasswordSMSFragment()


    }
}