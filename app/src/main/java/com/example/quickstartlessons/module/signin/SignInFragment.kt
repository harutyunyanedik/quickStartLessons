package com.example.quickstartlessons.module.signin

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentSignInBinding
import com.example.quickstartlessons.module.base.utils.QsConstants

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
            findNavController().navigate(SignInFragmentDirections.actionGlobalResetPasswordFragment())
        }

        binding.signInButton.setOnClickListener {
            validate()
        }
    }

    private fun validate() {
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        when {
            isValidEmail(email) && isValidPassword(password) -> startActivity(Intent(requireContext(), MainActivity::class.java))
            !isValidEmail(email) && !isValidPassword(password) -> {
                binding.emailUsernameInputLayout.error = getString(R.string.invalid_email)
                binding.passwordInputLayout.error = getString(R.string.invalid_password)
            }

            isValidEmail(email) && !isValidPassword(password) -> {
                binding.emailUsernameInputLayout.error = QsConstants.EMPTY_STRING
                binding.passwordInputLayout.error = getString(R.string.invalid_password)
            }

            !isValidEmail(email) && isValidPassword(password) -> {
                binding.emailUsernameInputLayout.error = getString(R.string.invalid_email)
                binding.passwordInputLayout.error = QsConstants.EMPTY_STRING
            }

            email.isEmpty() && password.isEmpty() -> {
                binding.emailUsernameInputLayout.error = getString(R.string.field_required)
                binding.passwordInputLayout.error = getString(R.string.field_required)
            }
        }
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6

    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
}