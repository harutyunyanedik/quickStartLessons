package com.example.quickstartlessons.module.launch

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ActivitySplashBinding
import com.example.quickstartlessons.module.account.AccountMainTabFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val viewModel by viewModel<SplashViewModel>()
    private lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_splash)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewModel.getUser(true,1)
        setupObserve()
        startActivity(Intent(this,AccountMainTabFragment::class.java))
    }

    private fun setupObserve(){
        viewModel.userLiveData.observe(this){
            QSApplication.userProfileLiveData.postValue(it)
        }
    }
}