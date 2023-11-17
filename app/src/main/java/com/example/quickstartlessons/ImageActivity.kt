package com.example.quickstartlessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    lateinit var binding:ActivityImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_image)

    }
}