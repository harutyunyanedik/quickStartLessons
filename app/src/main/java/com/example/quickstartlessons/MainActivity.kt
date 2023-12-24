package com.example.quickstartlessons

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.module.albums.popuphomework.presentation.ItemsViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val viewModel : ItemsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
    }
}