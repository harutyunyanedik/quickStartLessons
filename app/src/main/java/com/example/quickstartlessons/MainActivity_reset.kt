package com.example.quickstartlessons

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.LayoutResetPasswordPageBinding

class MainActivity_reset: AppCompatActivity() {
    private lateinit var binding: LayoutResetPasswordPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.layout_reset_password_page)

        binding.resetPasswordEnterPhoneNumber.setText("enter phone number")

        binding.smsEmailRadioGroup.setOnCheckedChangeListener { radioGroup, i ->
            val text = if (radioGroup.checkedRadioButtonId == R.id.smsRb) "enter phone number" else "enter e-mail"
            binding.resetPasswordEnterPhoneNumber.setText(text)

        }


        binding.buttonReset.setOnClickListener{
            Toast.makeText(this, binding.resetPasswordEnterPhoneNumber.text.toString(),Toast.LENGTH_LONG).show()

        }
    }

}