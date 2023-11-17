package com.example.quickstartlessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.ActivityImageBinding
import com.example.quickstartlessons.databinding.ActivityMainBinding

class ImageActivity : AppCompatActivity() {
    private lateinit var binding:ActivityImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image)
        val imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTD5-__NLkUyWMGGkFvsFMBehz7pBRzXvCKA&usqp=CAU"
        Glide.with(this).load(imageUrl).into(binding.imageFull)
    }
}