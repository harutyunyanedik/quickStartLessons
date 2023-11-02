package com.example.quickstartlessons.resetpage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ActivityLoginPageBinding


class LoginPageActivity : AppCompatActivity() {
    private lateinit var login: ActivityLoginPageBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        login = DataBindingUtil.setContentView(this, R.layout.activity_login_page)
        getSharedValue("login")
        getSharedValue("password")
        login.button.setOnClickListener {
            setSharedValue("login", "Areg")
            setSharedValue("password", "areg")

            if (getSharedValue("login") != login.name.text.toString() && getSharedValue("password") != login.password.text.toString()) {
                Toast.makeText(this, "username or password is incorrect", Toast.LENGTH_LONG).show()
            } else {
                val i = Intent(this, LoginPgeTwo::class.java)
                startActivity(i)
            }
            if (login.name.text.isEmpty() || login.password.text.isEmpty()) {
                Toast.makeText(this, "Username and password must be filled in", Toast.LENGTH_LONG)
                    .show()
            }

        }

        login.forgotPassword.setOnClickListener {
            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)
        }
        login.box.setOnCheckedChangeListener { view, isChecked ->
            if (view.isPressed && login.name.text.isNotEmpty() && login.password.text.isNotEmpty()) {
                login.name.setText("Areg")
                login.password.setText("areg")

            }
        }
    }
}