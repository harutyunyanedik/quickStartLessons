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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountMainTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    @SuppressLint("SetTextI18n")
    private fun setUpViews() {
        QSApplication.usersLiveData.observe(viewLifecycleOwner) {
            val user = it.userDtoToUser(it)
            with(binding) {
                Glide.with(requireContext()).load(user.image).into(userImage)
                userName.text = "${user.name} ${user.lastName}"
                email.text = user.email
                personalInformation.setOnClickListener {
                    findNavController().navigate(
                        AccountMainTabFragmentDirections.actionPersonalInformationFragment()
                    )
                }
            }
        }

        binding.settingsIcon.setOnClickListener {
            findNavController().navigate(AccountMainTabFragmentDirections.actionSettingsFragment())


        }

    }
}