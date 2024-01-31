package com.example.quickstartlessons.module.launch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity() : AppCompatActivity() {

    private val viewModel: UsersViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        viewModel.getUsers()
        viewModel.usersLiveData.observe(this) {
            QSApplication.users.value = it
        }

        findNavController(R.id.action_global_accountFragment)
    }


}