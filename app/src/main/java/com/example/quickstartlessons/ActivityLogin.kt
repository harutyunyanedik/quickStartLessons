package com.example.quickstartlessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import com.example.quickstartlessons.R.id.activiedittext
import com.example.quickstartlessons.databinding.DataLayoutBinding

class ActivityLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val checkbox = findViewById<CheckBox>(R.id.checkbox)
        val checkboxemail = findViewById<CheckBox>(R.id.checkbox2)
        val editTextHello = findViewById<EditText>(R.id.activiedittext)
        checkbox.setOnCheckedChangeListener { view, isChecked ->
            if (view.isChecked) {
                editTextHello.hint = "E-mail"
             //   checkboxemail.isPressed
            } else {
                editTextHello.hint = "Enter phone number"
            }
        }
    }
}
