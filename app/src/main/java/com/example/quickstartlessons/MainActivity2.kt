package com.example.quickstartlessons

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main2)

    binding.CheckboxSms.setOnClickListener{ }
        binding.CheckboxMail.setOnClickListener{ }
        binding.textForEnter.setOnClickListener{
            if (binding.CheckboxSms.isChecked) {
                binding.CheckboxMail.isChecked=false
                binding.textForEnter.hint=""


            }
             if (binding.CheckboxMail.isChecked) {
                 binding.CheckboxSms.isChecked=false
                 binding.textForEnter.hint=""
                 binding.textForEnter.resources.getText(R.style"@style/mail")

             }
        }

        binding.buttonForSignIn1.setOnClickListener{

            Toast.makeText(this , binding.textForEnter.text.toString(), Toast.LENGTH_LONG).show()
        }

    }
}


