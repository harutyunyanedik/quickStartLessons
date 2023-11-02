package com.example.quickstartlessons

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.edit
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.ActivityLoginPageBinding
import com.example.quickstartlessons.kotlin.getValue
import com.example.quickstartlessons.kotlin.setValue

class LoginPageActivity : AppCompatActivity() {
    private lateinit var login: ActivityLoginPageBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        login = DataBindingUtil.setContentView(this, R.layout.activity_login_page)
        getValue("login")
         //  getValue("password")
         login.button.setOnClickListener {
             setValue("login", "Areg")
           // setValue("password","areg")

            if ( getValue("login")!=login.name.text.toString() && getValue("password")!=login.password.text.toString()){
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
    }
}