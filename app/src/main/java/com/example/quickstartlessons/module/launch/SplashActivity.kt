package com.example.quickstartlessons.module.launch

import android.os.Bundle
import com.example.quickstartlessons.R
import com.example.quickstartlessons.module.base.activity.BaseActivity

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}