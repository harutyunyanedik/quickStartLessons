package com.example.quickstartlessons

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.presentation.AlbumViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: AlbumViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.alertDialogButton.setOnClickListener {
            viewModel.getAlbum()
        }

        binding.btn2.setOnLongClickListener {
            showAlertDialog {

            }
            true
        }

        viewModel.albumLiveData.observe(this) {
            println(it)
        }
    }
}