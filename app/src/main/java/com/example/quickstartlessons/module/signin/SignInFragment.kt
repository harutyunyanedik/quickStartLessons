package com.example.quickstartlessons.module.signin
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
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

        binding.emailEditText.doAfterTextChanged {
            if (!Patterns.EMAIL_ADDRESS.matcher(it.toString()).matches() || it.toString().matches(".*[0-9].*".toRegex())) {
                binding.emailUsernameInputLayout.error = "Invalid Email address or username "
            } else {
                binding.emailUsernameInputLayout.error = null
            }
        }
        binding.passwordEditText.doAfterTextChanged {
            for (i in 0..it.toString().length) {
               // if (!it.toString().matches(".*[0-9].*".toRegex())) {
               //     binding.passwordInputLayout.error = "Password must contain at least one number"
               // }
                if (it.toString().length < 6) {
                    binding.passwordInputLayout.error = " Password must be longer than 6 characters"

                } else {
                    binding.emailUsernameInputLayout.error = null
                }
            }
        }
    }



    //  private fun helperText() {
    //      binding.emailEditText.setOnFocusChangeListener { _, focus ->
    //          if (!focus) {
    //              binding.emailUsernameInputLayout.helperText = validEmailText()
    //          }
    //      }
    //      binding.passwordEditText.setOnFocusChangeListener{_, focus->
    //          if(!focus){
    //              binding.passwordInputLayout.helperText=validPassword()
    //          }

    //      }
    //  }

    //  private fun validEmailText(): String? {
    //      val emailText = binding.emailEditText.text.toString()
    //      if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()|| emailText.matches(".*[0-9].*".toRegex())) {
    //          return "Invalid Email address"
    //      }

    //      return null
    //  }

    //  private fun validPassword(): String? {
    //      val passwordText = binding.passwordEditText.text.toString()
    //      if (passwordText.length < 6) {
    //          return "Password must be longer than 6 characters"
    //      }
    //      if(!passwordText.matches(".*[0-9].*".toRegex())){
    //          return "Password must contain at least one number"
    //      }
    //      return null
    //  }
}