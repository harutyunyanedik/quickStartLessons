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
        setupObserve()
    }

    private fun setupViews() { //todo setupView i mej drel es click
        binding.forgotPasswordTextView.setOnClickListener {
            findNavController().navigate(SignInFragmentDirections.actionGlobalResetPasswordFragment())
        }
    }

    private val userName = binding.emailEditText.text.toString() // todo senc ban ches kara anes qani binding e init chi exel esa exception e (Caused by: kotlin.UninitializedPropertyAccessException: lateinit property binding has not been initialized), global ches kara pahes tar fun i mej
    private val password = binding.passwordEditText.text.toString()
    private fun validate() {
        when {
            isValidEmail(userName) && isValidPassword(password) -> {
                //todo livedata in stex petq chi observe linel es eje bacveluya erb vor liveData n arjeq unena, aysinwn stex karas uxxaki arjeqe vercnes splashActivity.viewModel.usersLiveData.value.users
                // todo stex arden piti qo logikan, petqa stex stuges userneri listum ka qo username password ov user te che

                val users = splashActivity?.viewModel?.usersLiveData?.value?.users
            }

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

    private fun isValidPassword(password: String): Boolean = password.length > 3
    private fun isValidEmail(userName: String): Boolean = true


    private fun setupObserve() { // todo setupObserve i mej drel es listener
        binding.signInButton.setOnClickListener { view ->
            // todo observe es anum listener i mej, sxala, du unes validate fun, dra mej petqa stugum e anes, u observe i kariq chka, karas miangamic liveData i value n vercnes


            // todo QSApplication.userProfileLiveData es qez talisa mi hat user, heto es kara null lini, es arjeq a unenalu en depqum erb vor du mi angam login anes, qez petqa endhanur userneri liste
            QSApplication.userProfileLiveData.observe(viewLifecycleOwner) {
                if (it != null) {
                    if (password == it.password && userName == it.username && binding.rememberMeCheckbox.isChecked) {
                        PreferencesManager.putUserName(it.username)
                        PreferencesManager.putUserPassword(it.password)

                        findNavController().navigate(SignInFragmentDirections.actionGlobalAccountFragment()) // todo petqa voch te baces account ayl start anes MainActivity
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

                // todo mi xosqov es gice lriv sxala
            }
        }
    }
}


