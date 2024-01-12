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

        binding.emailEditText.setOnFocusChangeListener { view, isFocused ->
            val text = (view as EditText).text.toString()
            if (!isFocused)
                if (!Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
                    binding.emailUsernameInputLayout.error = "Invalid Email address or username"
                }
        }

        binding.passwordEditText.setOnFocusChangeListener { view, isFocused ->
            val text = (view as EditText).text.toString()
            if (!isFocused)
                (!TextUtils.isEmpty(text) && Patterns.EMAIL_ADDRESS.matcher(text).matches())
        }
    }
}