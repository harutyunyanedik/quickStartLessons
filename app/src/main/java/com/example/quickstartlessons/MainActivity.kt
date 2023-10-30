package com.example.quickstartlessons

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.android.ResetPassword
import com.example.quickstartlessons.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    lateinit var checkbox1: CheckBox
    lateinit var checkbox2: CheckBox
    lateinit var enterButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reset_password)

        val intent = Intent(this, ResetPassword::class.java)
        startActivity(intent)


        val checkbox1 = findViewById<CheckBox>(R.id.checkbox1)
        val checkbox2 = findViewById<CheckBox>(R.id.checkbox2)
        val enterButton = findViewById<Button>(R.id.enter_button)

        if (checkbox1.isChecked) {
            enterButton.text = "Enter phone number"
        } else {
            enterButton.text = " "
        }

        if (checkbox2.isChecked) {
            enterButton.text = "E-mail"
        } else {
            enterButton.text = " "
        }


    }
}