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

        binding.emailEditText.doOnTextChanged { text, start, count, after ->
            if (text?.contains("@") != true){
                binding.emailTil.error = getString(R.string.invalid_email)
            } else{
                binding.emailTil.error = null
            }
        }
        binding.passwordEditText.doOnTextChanged { text, start, count, after ->
            if (text.isNullOrEmpty() || text.length < 8){
                binding.passwordTil.error = getString(R.string.invalid_password)
            } else{
                binding.passwordTil.error = null
            }
        }


        binding.signInButton.setOnClickListener {

        }
    }
}