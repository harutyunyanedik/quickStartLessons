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

        login.button.setOnClickListener {
            if(login.name.text.isEmpty() || login.password.text.isEmpty()){
                Toast.makeText(this,"Username and password must be filled in",Toast.LENGTH_LONG).show()
            }
            Log.d("password","Incorrectly entered")
        }

        login.forgotPassword.setOnClickListener {
            val intent=Intent(this,ResetPasswordActivity::class.java )
            startActivity(intent)
        }
    }
}