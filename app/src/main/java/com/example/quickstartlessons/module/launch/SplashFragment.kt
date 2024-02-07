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
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.base.utils.PreferencesManager
import com.example.quickstartlessons.module.base.utils.splashActivity

class SplashFragment : BaseFragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashActivity?.viewModel?.getAllUsers()
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
        observeLiveData()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun observeLiveData() {
        splashActivity?.viewModel?.usersLiveData?.observe(viewLifecycleOwner) { users ->
            if (users != null) {
                val user = users.users.find {
                    it.username == PreferencesManager.getUserNameFromPref()
                            && it.password == PreferencesManager.getUserPasswordFromPref()
                }
                user?.let {
                    QSApplication.userLiveData.value = it
                    startActivity(Intent(requireContext(), MainActivity::class.java))
                }?:run{
                    findNavController().navigate(SplashFragmentDirections.actionGlobalSignInFragment())
                }
            } else Toast.makeText(requireContext(), "Users list is empty", Toast.LENGTH_SHORT).show()
        }
    }
}

