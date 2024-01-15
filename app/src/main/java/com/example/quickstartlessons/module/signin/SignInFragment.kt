package com.example.quickstartlessons.module.signin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle

import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
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

    @SuppressLint("SuspiciousIndentation")
    private fun setupViews() {

        binding.forgotPasswordTextView.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_resetPasswordViewPagerFragment)
        }

        binding.emailEditText.doAfterTextChanged {
            val userNameText = it.toString()

            binding.passwordEditText.doAfterTextChanged { text ->
                val passwordText = text.toString()

                binding.signInButton.setOnClickListener {
                    when {
                        !Patterns.EMAIL_ADDRESS.matcher(userNameText).matches() -> {
                            binding.emailUsernameInputLayout.error = "Invalid Email address or username"

                        }

                        passwordText.length < 6 -> {
                            binding.passwordEditText.error = "Password must be 6 or more characters"
                        }

                        else ->
                            startActivity(Intent(requireContext(), MainActivity::class.java))

                    }
                }
            }
        }
    }

}


