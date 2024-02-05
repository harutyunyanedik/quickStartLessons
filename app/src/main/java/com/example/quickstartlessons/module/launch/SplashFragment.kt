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
import com.example.quickstartlessons.module.account.users.data.UserDto
import com.example.quickstartlessons.module.account.users.data.UsersDto
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.base.utils.PreferencesManager

class SplashFragment : BaseFragment() {

    private var currentUserName: String? = null
    private var currentPassword: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity() as SplashActivity).viewModel.getUsers()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeLiveData()
    }

    private fun setupViews() {
        currentUserName = PreferencesManager.getCurrentUserName()
        currentPassword = PreferencesManager.getCurrentPassword()
    }

    private fun observeLiveData() {
        (requireActivity() as SplashActivity).viewModel.usersLiveData.observe(viewLifecycleOwner) {
            if (it != null){
                if (checkUser(it) != null){
                    QSApplication.usersLiveData.value = checkUser(it)
                    startActivity(Intent(requireActivity(), MainActivity::class.java))
                } else {
                    findNavController().navigate(R.id.action_global_signInFragment)
                }
            }
        }
    }

    private fun checkUser(users: UsersDto): UserDto? {
        if (currentUserName == null && currentPassword == null) return null
        for (user in users.users){
            if (user.userName == currentUserName && user.password == currentPassword){
                return user
            }
        }
        return null
    }
}