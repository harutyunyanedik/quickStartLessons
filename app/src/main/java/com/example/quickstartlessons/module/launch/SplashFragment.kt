package com.example.quickstartlessons.module.launch

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.databinding.FragmentSplashBinding
import com.example.quickstartlessons.module.Users.viewModel.UsersViewModel
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.base.utils.PreferencesManager


import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment() {

    private lateinit var binding: FragmentSplashBinding
    private val viewModel by viewModel<UsersViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getAllUsers()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findNavController().navigate(SplashFragmentDirections.actionGlobalSignInFragment())
        observeLiveData()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun observeLiveData() {
        viewModel.usersLiveData.observe(viewLifecycleOwner) {
            QSApplication.userProfileLiveData.value = it
            if (it != null) {
                for (i in 0..it.users.size) {
                    if (it.users[i].username != PreferencesManager.getUserNameFromPref()
                        && it.users[i].password != PreferencesManager.getUserPasswordFromPref()
                    ) {
                        Toast.makeText(requireContext(), "Invalid password / username!", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(SplashFragmentDirections.actionGlobalSignInFragment())
                    }else{
                        findNavController().navigate(SplashFragmentDirections.actionGlobalAccountFragment())
                    }
                }
            } else Toast.makeText(requireContext(), "Users list is empty", Toast.LENGTH_SHORT).show()
                startActivity(Intent(requireContext(), MainActivity::class.java))
        }
        viewModel.usersErrorLiveData.observe(viewLifecycleOwner)
        {
            showErrorMessageDialog("Error Dialog", it)
        }
    }

    companion object {
        const val KEY_USERS_ID = "key_users_id"
    }
}

