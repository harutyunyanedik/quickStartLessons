package com.example.quickstartlessons.activites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image)
        val imageUral = intent.getStringExtra(MainActivity.EXTRA_IMAGE_URL)
        Glide.with(this).load(imageUral).into(binding.imageViewFullImage)
    }
}