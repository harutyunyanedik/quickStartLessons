package com.example.quickstartlessons.module.account

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.databinding.FragmentAccountMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment

class AccountMainTabFragment : BaseFragment() {

    private lateinit var binding: FragmentAccountMainTabBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountMainTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        binding.settings.setOnClickListener {
            findNavController().navigate(AccountMainTabFragmentDirections.actionGlobalSettingsFragment())
        }

        binding.personalData.setOnClickListener {
            findNavController().navigate(AccountMainTabFragmentDirections.actionGlobalPersonalDataFragment())
        }

    }

    @SuppressLint("SetTextI18n")
    private fun observeLiveData() {

        QSApplication.userProfileLiveData.observe(viewLifecycleOwner) {
            val profile = it.users.getOrNull(0)
            binding.userMail.text = profile?.email
            binding.userName.text = profile?.firstName + profile?.lastName
            Glide.with(requireContext()).load(profile?.image).into(binding.profileImage)
        }

    }
}