package com.example.quickstartlessons.module.signin

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
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

        fun validEmail(): Boolean {
            val text = binding.emailEditText.text.toString()
            return if (Patterns.EMAIL_ADDRESS.matcher(text).matches() && text.isNotEmpty()) {
                binding.emailUsernameInputLayout.error = null
                true
            } else {
                false
            }
        }

        fun validPassword(): Boolean {
            val text = binding.passwordEditText.text.toString()
            return if (text.length > 6) {
                binding.passwordInputLayout.error = null
                true
            } else {
                false
            }

        }
        binding.signInButton.setOnClickListener {
            if (!validEmail()) {
                binding.emailUsernameInputLayout.error = "Invalid or empty Email address or username"
            }
            if (!validPassword()) {
                binding.passwordInputLayout.error = "Invalid password! Must by bigger 6 Characters!"
            } else {
                //
            }
        }
    }
}