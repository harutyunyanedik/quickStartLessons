package com.example.quickstartlessons

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.ItemImageBinding
import com.example.quickstartlessons.model.ImageModel

class ImageActivity : AppCompatActivity() {
    lateinit var binding: ItemImageBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.item_image)
        intent.getStringExtra("image1")


    }
}