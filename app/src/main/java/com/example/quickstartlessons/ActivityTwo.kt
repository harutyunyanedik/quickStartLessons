package com.example.quickstartlessons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.DataLayoutBinding

class ActivityTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

    }
}
//private lateinit var binding1: DataLayoutBinding
//
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    binding1 = DataBindingUtil.setContentView(this, R.layout.activity_two)
//    binding1.checkbox.setOnCheckedChangeListener { view, isChecked ->
//        if (view.isPressed) {
//            val intent = Intent(this, Activitythree::class.java)
//            startActivity(intent)
//
//        }
//    }