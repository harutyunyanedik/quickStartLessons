package com.example.quickstartlessons

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.android.LoginActivity
import com.example.quickstartlessons.android.getUserNameFromPref
import com.example.quickstartlessons.android.putUserNameTo
import com.example.quickstartlessons.databinding.ActivityBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity)
        binding.button1.setOnClickListener {
            putUserNameTo("login", "Diana")
            if (getUserNameFromPref("login") != binding.username.text.toString() && getUserNameFromPref(
                    "password"
                ) != binding.password.text.toString()
            ) {
                Toast.makeText(this, "username or password is incorrect", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            if (binding.username.text.isEmpty() && binding.password.text.isEmpty()) {
                Toast.makeText(this, "username or password must be filled in", Toast.LENGTH_LONG)
                    .show()
            }
        }

    }

}