package com.example.quickstartlessons.module.signin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentSignInBinding
import com.example.quickstartlessons.module.base.utils.PreferencesManager
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
        setupObserve()
    }

    private fun setupViews() {
        binding.forgotPasswordTextView.setOnClickListener {
            findNavController().navigate(SignInFragmentDirections.actionGlobalResetPasswordFragment())
        }
    }

    private val userName = binding.emailEditText.text.toString()
    private val password = binding.passwordEditText.text.toString()
    private fun validate() {

        when {
            isValidEmail(userName) && isValidPassword(password) -> startActivity(Intent(requireContext(), MainActivity::class.java))
            !isValidEmail(userName) && !isValidPassword(password) -> {
                binding.emailUsernameInputLayout.error = getString(R.string.invalid_email)
                binding.passwordInputLayout.error = getString(R.string.invalid_password)
            }

            isValidEmail(userName) && !isValidPassword(password) -> {
                binding.emailUsernameInputLayout.error = QsConstants.EMPTY_STRING
                binding.passwordInputLayout.error = getString(R.string.invalid_password)
            }

            !isValidEmail(userName) && isValidPassword(password) -> {
                binding.emailUsernameInputLayout.error = getString(R.string.invalid_email)
                binding.passwordInputLayout.error = QsConstants.EMPTY_STRING
            }

            userName.isEmpty() && password.isEmpty() -> {
                binding.emailUsernameInputLayout.error = getString(R.string.field_required)
                binding.passwordInputLayout.error = getString(R.string.field_required)
            }
        }
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6
    private fun isValidEmail(userName: String): Boolean = true


    private fun setupObserve() {
        binding.signInButton.setOnClickListener { view ->
            QSApplication.userProfileLiveData.observe(viewLifecycleOwner) {
                if (it != null) {
                    if (password == it.password && userName == it.username && binding.rememberMeCheckbox.isChecked) {
                        PreferencesManager.putUserName(it.username)
                        PreferencesManager.putUserPassword(it.password)

                        findNavController().navigate(SignInFragmentDirections.actionGlobalAccountFragment())
                    } else {
                        if (password == it.password && userName == it.username && !binding.rememberMeCheckbox.isChecked) {
                            binding.signInButton.setOnClickListener {
                                findNavController().navigate(SignInFragmentDirections.actionGlobalAccountFragment())
                            }
                        } else {
                            validate()
                        }
                    }
                }
            }
        }
    }
}


