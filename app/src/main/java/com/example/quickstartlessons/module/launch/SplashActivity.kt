package com.example.quickstartlessons.module.launch

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ActivitySplashBinding
import com.example.quickstartlessons.module.account.AccountMainTabFragment
import com.example.quickstartlessons.module.base.activity.BaseActivity
import com.example.quickstartlessons.module.user.data.response.UsersDto
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("CustomSplashScreen")
class SplashActivity :BaseActivity() {
    private val viewModel by viewModel<SplashViewModel>()
    private lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_splash)
        viewModel.getUsers()
        setupObserve()
        findNavController(R.id.action_global_accountFragment)
    }


    private fun setupObserve(){
        viewModel.usersLiveData.observe(this){
            QSApplication.userProfileLiveData.setValue(it)
        }
    }
}