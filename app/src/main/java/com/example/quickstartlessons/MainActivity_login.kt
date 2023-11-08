package com.example.quickstartlessons

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.LayoutLoginPageBinding

class MainActivity_login: AppCompatActivity(){

    private lateinit var binding: LayoutLoginPageBinding

    override fun onCreate(savedInstantState: Bundle?){
        super.onCreate(savedInstantState)
        binding = DataBindingUtil.setContentView(this,R.layout.layout_login_page)

        binding.checkboxRememberMe.setOnClickListener {

        }
        binding.buttonSignIn.setOnClickListener {
            Toast.makeText(this,binding.checkboxRememberMe.isChecked.toString(),Toast.LENGTH_SHORT).show()
            Toast.makeText(this,binding.loginPageUsername.text.toString(),Toast.LENGTH_SHORT).show()
            Toast.makeText(this,binding.loginPagePassword.text.toString(),Toast.LENGTH_SHORT).show()
        }

        binding.buttonContactSupport.setOnClickListener{
            val intent = Intent(this,MainActivity_reset::class.java)
            startActivity(intent)
        }

    }



}