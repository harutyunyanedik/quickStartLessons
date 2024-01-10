package com.example.quickstartlessons.module.resetpassword.email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.quickstartlessons.databinding.FragmentResetPasswordEmailBinding

class ResetPasswordEmailFragment : Fragment() {

    private lateinit var binding: FragmentResetPasswordEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResetPasswordEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.getEmail.doAfterTextChanged {
            binding.buttonResetPassword.isEnabled = !it.isNullOrEmpty() && !binding.getEmail.text.isNullOrEmpty()
        }

        binding.getEmail.doOnTextChanged { text, start, before, count ->
            val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
            when {
                text.isNullOrEmpty() -> {
                    binding.getEmailLayout.error = "Required"
                }

                !text.matches(emailRegex.toRegex()) -> {
                    binding.getEmailLayout.error = "Valid E-mail"
                }

                else -> {
                    binding.getEmailLayout.error = null
                }
            }
        }

      binding.buttonResetPassword.setOnClickListener{

      }

    }
    companion object{
        fun newInstance() = ResetPasswordEmailFragment()
    }
}