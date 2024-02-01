package com.example.quickstartlessons.module.launch

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ActivitySplashBinding
import com.example.quickstartlessons.module.base.activity.BaseActivity
import com.example.quickstartlessons.module.home.ui.viewModel.UsersViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val viewModel by viewModel<UsersViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        viewModel.getAllUsers()
       observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.usersLiveData.observe(this) {
            QSApplication.userProfileLiveData.value = it
            if (it != null) findNavController(R.id.action_global_accountFragment)
            else Toast.makeText(this,"users list is empty",Toast.LENGTH_SHORT).show()
        }
    }
}

