package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.module.albums.newpresenttation.HeaderPageFragment
import com.example.quickstartlessons.module.albums.newpresenttation.PopUpFragment
import org.koin.android.ext.android.get

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val fragment = HeaderPageFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.activity_container, fragment).commit()
    }

}