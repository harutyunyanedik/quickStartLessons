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
import com.example.quickstartlessons.module.Users.data.response.UserDto
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.base.utils.PreferencesManager
import com.example.quickstartlessons.module.base.utils.QsConstants
import com.example.quickstartlessons.module.base.utils.splashActivity


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
            if (validate()) {
                startActivity(Intent(requireContext(), MainActivity::class.java))
                splashActivity?.finish()
            }
        }
    }

    private fun validate(): Boolean {
        val username = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        when {
            isValidEmail(username) && isValidPassword(password) -> {
                val users = splashActivity?.viewModel?.usersLiveData?.value?.users
                if (checkUser(username, password) != null && users != null && binding.rememberMeCheckbox.isChecked) {
                    PreferencesManager.putUserNameToPref(username)
                    PreferencesManager.putUserPasswordToPref(password)
                    QSApplication.userLiveData.value = checkUser(username, password)
                    Toast.makeText(requireContext(), "Your registration is successful!", Toast.LENGTH_SHORT).show()
                }
                if (checkUser(username, password) != null && users != null && !binding.rememberMeCheckbox.isChecked) {
                    QSApplication.userLiveData.value = checkUser(username, password)
                }
                return true
            }

            !isValidEmail(username) && !isValidPassword(password) -> {
                binding.emailUsernameInputLayout.error = getString(R.string.invalid_email)
                binding.passwordInputLayout.error = getString(R.string.invalid_password)
                return false
            }

            isValidEmail(username) && !isValidPassword(password) -> {
                binding.emailUsernameInputLayout.error = QsConstants.EMPTY_STRING
                binding.passwordInputLayout.error = getString(R.string.invalid_password)
                return false
            }

            !isValidEmail(username) && isValidPassword(password) -> {
                binding.emailUsernameInputLayout.error = getString(R.string.invalid_email)
                binding.passwordInputLayout.error = QsConstants.EMPTY_STRING
                return false
            }

            username.isEmpty() && password.isEmpty() -> {
                binding.emailUsernameInputLayout.error = getString(R.string.field_required)
                binding.passwordInputLayout.error = getString(R.string.field_required)
                return false
            }
        }
        return false
    }


    private fun isValidPassword(password: String): Boolean = password.length > 3
    private fun isValidEmail(email: String): Boolean = email.length > 4
// private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun checkUser(username: String, password: String): UserDto? = splashActivity?.viewModel?.usersLiveData?.value?.users?.find {
        it.username == username && it.password == password
    }
}


