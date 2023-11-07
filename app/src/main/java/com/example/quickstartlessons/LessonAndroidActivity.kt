package com.example.quickstartlessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.LessonAndroidBinding

class LessonAndroidActivity : AppCompatActivity() {
    private lateinit var binding: LessonAndroidBinding
    private lateinit var adaptor: AdaptorRecycler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.lesson_android)
        workApp()
    }

    fun workApp() {
        val manager = LinearLayoutManager(this)
        binding.lessonRecycler.adapter=adaptor
        binding.lessonRecycler.layoutManager=manager
    }
}