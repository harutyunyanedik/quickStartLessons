package com.example.quickstartlessons

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forgot_password)

        binding.checkboxSms.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                binding.checkboxMail.isChecked = false
            }
        }

        binding.checkboxMail.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                binding.checkboxSms.isChecked = false
            }
        }

        binding.buttonForSignIn1.setOnClickListener {
            Toast.makeText(this, binding.textForEnter.text.toString(), Toast.LENGTH_LONG).show()
        }

    }
}


