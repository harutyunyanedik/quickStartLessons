package com.example.quickstartlessons

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.example.quickstartlessons.android.ActivityTwo


class MainActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in_page)

        val btnusername = findViewById<EditText>(R.id.username)
        val btnpassword = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login_button)

        val sharedpreferences = getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)
        val getUsername = sharedpreferences.getString("USERNAME", "")
        val getPassword = sharedpreferences.getString("PASSWORD", "")


        if (getUsername != "" && getPassword != "") {
            val i = Intent(this, ActivityTwo::class.java)
        } else {
            Toast.makeText(this, "Incorrect Login Details", Toast.LENGTH_LONG).show();
        }

        login.setOnClickListener {
            val username = btnusername.text.toString()
            val password = btnpassword.text.toString()

            val editor = sharedpreferences.edit()
            editor.putString("USERNAME", username)
            editor.putString("PASSWORD", password)
            editor.apply()

            val i = Intent(this, ActivityTwo::class.java)
            startActivity(i)
        }

    }
}








