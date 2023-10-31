package com.example.quickstartlessons.android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.MainActivity.Companion.ACTIVITY_EXTRA_KEY
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ActivityTwoBinding

class ActivityTwo : AppCompatActivity() {

    private lateinit var binding: ActivityTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_two)

        val value = intent.getStringExtra(ACTIVITY_EXTRA_KEY)

        binding.txt.text = "hello"

        binding.txt.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("key", "result is ok")
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}