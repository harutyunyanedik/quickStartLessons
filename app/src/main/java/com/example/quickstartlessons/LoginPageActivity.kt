package com.example.quickstartlessons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.ActivityLoginPageBinding

class LoginPageActivity : AppCompatActivity() {
    private lateinit var login:ActivityLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       login=DataBindingUtil.setContentView(this,R.layout.activity_login_page)
        login.password.setOnClickListener {
            //Log.d("password","Incorrectly entered password")
            Toast.makeText(this,"Password must contain at least 8 characters: one uppercase letter, one lowercase letter, one number and one symbol.",Toast.LENGTH_LONG).show()

        }

        login.forgotPassword.setOnClickListener {
            val intent=Intent(this,ResetPasswordActivity::class.java )
            startActivity(intent)
        }
    }
}