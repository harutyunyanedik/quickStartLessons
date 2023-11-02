package com.example.quickstartlessons.resetpage

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ActivityResetPasswordBinding

class ResetPasswordActivity : AppCompatActivity() {
    private lateinit var reset: ActivityResetPasswordBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reset = DataBindingUtil.setContentView(this, R.layout.activity_reset_password)
        reset.radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            if (radioGroup.checkedRadioButtonId == R.id.sms) {
                reset.enterData.hint="Enter number phone"
                }else {
                reset.enterData.hint = " e-mail"
                }

            }

        }
    }

