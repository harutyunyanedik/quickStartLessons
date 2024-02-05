package com.example.quickstartlessons.module.signin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentSignInBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.base.utils.PreferencesManager
import com.example.quickstartlessons.module.base.utils.splashActivity
import com.example.quickstartlessons.module.users.data.net.UserDto

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
                startActivity(Intent(requireActivity(), MainActivity::class.java))
                splashActivity?.finish()
            }
        }
    }

    private fun validate(): Boolean {
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        when {
            email.isEmpty() && password.isEmpty() -> {
                binding.emailUsernameInputLayout.error = getString(R.string.field_required)
                binding.passwordInputLayout.error = getString(R.string.field_required)
                return false
            }

            checkUser(email, password) != null && binding.rememberMeCheckbox.isChecked -> {
                PreferencesManager.putCurrentUserName(email)
                PreferencesManager.putCurrentPassword(password)
                QSApplication.userLiveData.value = checkUser(email, password)
                return true
            }

            checkUser(email, password) != null && !binding.rememberMeCheckbox.isChecked -> {
                QSApplication.userLiveData.value = checkUser(email, password)
                return true
            }

            checkUser(email, password) == null -> {
                binding.emailUsernameInputLayout.error = getString(R.string.invalid_username_or_password)
                binding.passwordInputLayout.error = getString(R.string.invalid_username_or_password)
                return false
            }
        }
        return false
    }

    private fun checkUser(email: String, password: String): UserDto? = splashActivity?.viewModel?.usersLiveData?.value?.users?.find {
        it.userName == email && it.password == password
    }
}