package com.example.quickstartlessons.module.launch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentSplashBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.base.utils.PreferencesManager
import com.example.quickstartlessons.module.home.ui.HomeMainTabViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    private val viewModel by viewModel<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getUsers()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserve()
    }
    private fun setupObserve() {
        viewModel.usersLiveData.observe(viewLifecycleOwner) { it ->
            val user = it?.users
            if (user != null) {
                for (i in user.indices) {
                    if (user[i].password == PreferencesManager.getUserName() && user[i].username == PreferencesManager.getUserPassword()) {
                        QSApplication.userProfileLiveData.value=user[i]
                        findNavController().navigate(SplashFragmentDirections.actionGlobalAccountFragment())
                    }else{
                        findNavController().navigate(SplashFragmentDirections.actionGlobalSignInFragment())
                    }

                }
            }
        }
    }
}
