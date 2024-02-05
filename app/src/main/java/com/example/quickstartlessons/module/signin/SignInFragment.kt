package com.example.quickstartlessons.module.signin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentSignInBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.base.utils.PreferencesManager
import com.example.quickstartlessons.module.base.utils.QsConstants


class SignInFragment : BaseFragment() {

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
            if (it.isPressed) {
                validate()
            }
        }
    }

    private fun validate() {
        val username = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        when {
            isValidEmail(username) && isValidPassword(password) -> {
                val users = QSApplication.userProfileLiveData.value
                if (users != null) {
                    for (i in 0..users.users.size) {
                        if ((username == users.users[i].username) && (password == users.users[i].password) && binding.rememberMeCheckbox.isChecked) {

                            PreferencesManager.putUserNameToPref(username)
                            PreferencesManager.putUserPasswordToPref(password)

                            val user =   users.users.find {
                                it.username == PreferencesManager.getUserNameFromPref() &&
                                        it.password == PreferencesManager.getUserPasswordFromPref()
                            }
                            QSApplication.usersProfile.value = users.users[i]
                            startActivity(Intent(requireContext(), MainActivity::class.java))
                            Toast.makeText(requireContext(), "Your registration is successful!", Toast.LENGTH_SHORT).show()

                        } else if (username == users.users[i].username && password == users.users[i].password && !binding.rememberMeCheckbox.isChecked) {
                            val user =   users.users.find {
                                it.username == PreferencesManager.getUserNameFromPref() &&
                                        it.password == PreferencesManager.getUserPasswordFromPref()
                            }
                            QSApplication.usersProfile.value = user
                            startActivity(Intent(requireContext(), MainActivity::class.java))
                        } else {
                            findNavController().navigate(SignInFragmentDirections.actionGlobalSplashFragment())
                            //Toast.makeText(requireContext(), "Invalid password / username!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

            !isValidEmail(username) && !isValidPassword(password) -> {
                binding.emailUsernameInputLayout.error = getString(R.string.invalid_email)
                binding.passwordInputLayout.error = getString(R.string.invalid_password)
            }

            isValidEmail(username) && !isValidPassword(password) -> {
                binding.emailUsernameInputLayout.error = QsConstants.EMPTY_STRING
                binding.passwordInputLayout.error = getString(R.string.invalid_password)
            }

            !isValidEmail(username) && isValidPassword(password) -> {
                binding.emailUsernameInputLayout.error = getString(R.string.invalid_email)
                binding.passwordInputLayout.error = QsConstants.EMPTY_STRING
            }

            username.isEmpty() && password.isEmpty() -> {
                binding.emailUsernameInputLayout.error = getString(R.string.field_required)
                binding.passwordInputLayout.error = getString(R.string.field_required)
            }
        }
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6
    private fun isValidEmail(email: String): Boolean = email.length > 5
    // private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

}


