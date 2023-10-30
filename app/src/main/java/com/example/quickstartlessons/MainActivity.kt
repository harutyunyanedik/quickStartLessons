package com.example.quickstartlessons

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.*
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding= setContentView(this,R.layout.activity_main)

        binding.textForMail.setOnClickListener{
          val mail = binding.textForMail.text.toString()
        }

        binding.textForPassword.setOnClickListener{
          val password = binding.textForPassword.text.toString()
        }

        binding.checkbox.setOnClickListener{

        }
        binding.buttonForSignIn.setOnClickListener{
       Toast.makeText(this , binding.checkbox.isChecked.toString(),Toast.LENGTH_LONG).show()
          Toast.makeText(this , binding.textForMail.text.toString(),Toast.LENGTH_LONG).show()
          Toast.makeText(this , binding.textForPassword.text.toString(),Toast.LENGTH_LONG).show()
        }
        binding.buttonForForgive.setOnClickListener{
           val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }


}