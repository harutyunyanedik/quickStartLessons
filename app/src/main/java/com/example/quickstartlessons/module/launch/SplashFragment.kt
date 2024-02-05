package com.example.quickstartlessons.module.launch

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.R
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.base.utils.PreferencesManager

class SplashFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity() as SplashActivity).viewModel.getUsers()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
    }

    private fun observeLiveData() {
        (requireActivity() as SplashActivity).viewModel.usersLiveData.observe(viewLifecycleOwner) { users ->
            if (users != null) {
                val user = users.users.find { user ->
                    user.userName == PreferencesManager.getCurrentUserName() && user.password == PreferencesManager.getCurrentPassword()
                }

                user?.let {
                    QSApplication.userLiveData.value = it
                    startActivity(Intent(requireActivity(), MainActivity::class.java))
                } ?: run {
                    findNavController().navigate(R.id.action_global_signInFragment)
                }
            }
        }
    }
}