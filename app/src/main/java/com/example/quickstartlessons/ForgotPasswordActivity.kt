package com.example.quickstartlessons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var biding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = DataBindingUtil.setContentView(this, R.layout.activity_forgot_password)
        biding.radioButtonSMS.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                biding.editTextResetPassword.hint = getString(R.string.enter_phone_number)
                biding.editTextResetPassword.inputType = android.text.InputType.TYPE_CLASS_NUMBER
            }
        }

        biding.radioButtonEmail.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                biding.editTextResetPassword.hint = getString(R.string.email)
                biding.editTextResetPassword.inputType = android.text.InputType.TYPE_CLASS_TEXT
            }
        }
        biding.textViewReset.setOnClickListener {
            if (biding.editTextResetPassword.text.isBlank()) {
                Toast.makeText(
                    this,
                    getString(R.string.please_fill_in_all_fields),
                    Toast.LENGTH_SHORT
                ).show()
            } else if (biding.radioButtonSMS.isChecked) {
                if (UsersList.getUserByPhoneNumber(
                        biding.editTextResetPassword.text.toString().toInt()
                    ) != null
                ) {
                    val intent = Intent(this, ResetPasswordActivity::class.java)
                    intent.putExtra(
                        EXTRA_MESSAGE_SMS,
                        biding.editTextResetPassword.text.toString().toInt()
                    )
                    startActivity(intent)
                    Toast.makeText(
                        this,
                        getString(R.string.sms_has_been_sent_to_your_phone_number),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(this,
                        getString(R.string.the_phone_number_is_incorrect), Toast.LENGTH_SHORT).show()
                }
            } else {
                if (UsersList.getUserByEmail(
                        biding.editTextResetPassword.text.toString()
                    ) != null
                ) {
                    val intent = Intent(this, ResetPasswordActivity::class.java)
                    intent.putExtra(
                        EXTRA_MESSAGE_EMAIL,
                        biding.editTextResetPassword.text.toString()
                    )
                    startActivity(intent)
                    Toast.makeText(
                        this,
                        getString(R.string.the_email_has_been_sent_to_your_email_address),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(this, getString(R.string.the_email_address_is_incorrect), Toast.LENGTH_SHORT).show()
                }
            }
        }


    }

    companion object {
        const val EXTRA_MESSAGE_SMS = "sms"
        const val EXTRA_MESSAGE_EMAIL = "email"
    }
}