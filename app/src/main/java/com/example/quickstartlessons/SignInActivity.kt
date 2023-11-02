package com.example.quickstartlessons

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.SignInLayoutBinding

class SignInActivity : AppCompatActivity() {
    lateinit var biding: SignInLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = DataBindingUtil.setContentView(this, R.layout.sign_in_layout)
        biding.buttonSignIn.setOnClickListener {
            if (biding.editTextUserName.text.isNotBlank() &&
                biding.editTextPassword.text.isNotBlank()
            ) {
                if (getUserNameAndPassword(biding.editTextUserName.text.toString()) == biding.editTextPassword.text.toString()) {
                    Toast.makeText(
                        this,
                        "${biding.editTextUserName.text.toString()}\n${biding.editTextPassword.text.toString()}",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(this,
                        getString(R.string.username_or_password_is_incorrect), Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.please_fill_in_all_fields),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        biding.checkboxRememberMe.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                if (biding.editTextUserName.text.isNotBlank() && biding.editTextPassword.text.isNotBlank()) {
                    Toast.makeText(
                        this,
                        "${biding.editTextUserName.text.toString()}\n${biding.editTextPassword.text.toString()}",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this,
                        getString(R.string.please_fill_in_all_fields),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        biding.textViewForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        biding.buttonSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

    }

}