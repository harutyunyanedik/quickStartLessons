package com.example.quickstartlessons.module.signin

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.MainActivity
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

        binding.signInButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()){
                when {
                    !Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length < 8 -> {
                        binding.emailUsernameInputLayout.error = getString(R.string.invalid_email)
                        binding.passwordInputLayout.error = getString(R.string.invalid_password)
                    }
                    !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                        binding.emailUsernameInputLayout.error = getString(R.string.invalid_email)
                    }
                    password.length < 8 -> {
                        binding.passwordInputLayout.error = getString(R.string.invalid_password)
                    }
                    else -> {
                        val intent = MainActivity.newIntent(requireContext())
                        startActivity(intent)
                    }
                }
            } else {
                Toast.makeText(requireContext(), getString(R.string.please_fill_in_all_fields), Toast.LENGTH_SHORT).show()
            }
        }
        binding.emailEditText.doOnTextChanged { text, start, before, count ->
            binding.emailUsernameInputLayout.error = null
        }
        binding.passwordEditText.doOnTextChanged { text, start, before, count ->
            binding.passwordInputLayout.error = null
        }

    }
}