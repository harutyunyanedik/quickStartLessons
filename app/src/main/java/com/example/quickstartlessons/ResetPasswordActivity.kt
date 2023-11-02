package com.example.quickstartlessons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.ActivityResetPasswordBinding

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var biding: ActivityResetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = DataBindingUtil.setContentView(this, R.layout.activity_reset_password)
        val sms = intent.getIntExtra(ForgotPasswordActivity.EXTRA_MESSAGE_SMS, 0)
        val email = intent.getStringExtra(ForgotPasswordActivity.EXTRA_MESSAGE_EMAIL)
        biding.buttonResetPassword.setOnClickListener {
            if (biding.editTextNewPassword.text.toString().isNotBlank() &&
                biding.editTextRepeatNewPassword.text.toString().isNotBlank()
            ) {
                if (biding.editTextNewPassword.text.toString() == biding.editTextRepeatNewPassword.text.toString()) {
                    if (sms != 0) {
                        val user = UsersList.getUserByPhoneNumber(sms)
                        user?.let {
                            UsersList.removeUser(it)
                            it.password = biding.editTextNewPassword.text.toString()
                            UsersList.addUser(it)
                            putUserNameAndPassword(user.username, user.password)
                        }
                    } else if (email != null) {
                        val user = UsersList.getUserByEmail(email)
                        user?.let {
                            UsersList.removeUser(it)
                            it.password = biding.editTextNewPassword.text.toString()
                            UsersList.addUser(it)
                            putUserNameAndPassword(user.username, user.password)
                        }

                    }
                    Toast.makeText(this, getString(R.string.password_successfully_changed), Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, SignInActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        getString(R.string.passwords_do_not_match),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.please_fill_in_all_fields),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}