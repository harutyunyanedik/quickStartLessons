package com.example.quickstartlessons.module.account.personalData

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.databinding.FragmentPersonalDataBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment

class PersonalDataFragment : BaseFragment() {
    private lateinit var binding: FragmentPersonalDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonalDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
    }

    @SuppressLint("SetTextI18n")
    private fun observeLiveData() {
        QSApplication.userProfileLiveData.observe(viewLifecycleOwner) {
            val user = it.users.getOrNull(0)
            binding.userMail.text = user?.email
            binding.userName.text = user?.firstName + user?.lastName
            binding.birthDate.text = user?.birthDate
            binding.gender.text = user?.gender
            binding.phone.text = user?.phone
            Glide.with(requireContext()).load(user?.image).into(binding.profileImage)
        }
    }
}
