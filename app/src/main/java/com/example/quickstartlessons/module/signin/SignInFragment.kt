package com.example.quickstartlessons.module.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.forgotPasswordTextView.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_resetPasswordViewPagerFragment)
        }

        binding.emailEditText.doAfterTextChanged {
            binding.signInButton.isEnabled = !it.isNullOrEmpty() && !binding.passwordEditText.text.isNullOrEmpty()
        }

        binding.passwordEditText.doAfterTextChanged {
            binding.signInButton.isEnabled = !it.isNullOrEmpty() && !binding.emailEditText.text.isNullOrEmpty()
        }

        binding.passwordEditText.doOnTextChanged { text, start, before, count ->
            if (text!!.length < 6) {
                binding.passwordEditTextLayout.error = "Minimum 8 Character Password!"
            } else if (text.length > 8) {
                if (!text.matches(".*[A-Z].*".toRegex())) {
                    binding.passwordEditTextLayout.error = "Must contain 1 Upper_case Character!"
                }
                if (!text.matches(".*[a-z].*".toRegex())) {
                    binding.passwordEditTextLayout.error = "Must contain 1 Lower_case Character!"
                }
                if (!text.matches(".*[@#\$%^&+=].*".toRegex())) {
                    binding.passwordEditTextLayout.error = "Must contain 1 Special Character (@#\$%^&+=)!"
                }
            } else {
                binding.passwordEditTextLayout.error = null
            }
        }

        binding.emailEditText.doOnTextChanged { text, start, before, count ->
            val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
            when {
                text.isNullOrEmpty() -> {
                    binding.emailEditTextLayout.error = "Required"
                }

                !text.matches(emailRegex.toRegex()) -> {
                    binding.emailEditTextLayout.error = "Valid E-mail"
                }

                else -> {
                    binding.emailEditTextLayout.error = null
                }
            }
        }

        binding.signInButton.setOnClickListener {

        }
    }
}

