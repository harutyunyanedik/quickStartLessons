package com.example.quickstartlessons.module.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.databinding.FragmentAccountMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.mappers.UserMapper

class AccountMainTabFragment : BaseFragment() {

    private lateinit var binding: FragmentAccountMainTabBinding
    private val userMapper = UserMapper()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountMainTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }


    private fun setupViews() {
        QSApplication.users.observe(viewLifecycleOwner) {
            val user = userMapper.userDtoToUser(it.users[0])
            with(binding) {
                Glide.with(requireContext()).load(user?.image).into(profileImage)
                textViewName.text = "${user?.name} ${user?.lastName}" // todo handle warnings
                textViewMail.text = user?.email
                personalInformation.setOnClickListener {
                    findNavController().navigate(
                        AccountMainTabFragmentDirections.actionPersonalInformationFragment(
                            user!! // todo delete argument, no need to pass argument, because you can observe to usersLiveData in Personal details fragment
                        )
                    )
                }
            }
        }

        binding.checkboxSettings.setOnClickListener {
            findNavController().navigate(AccountMainTabFragmentDirections.actionSettingsFragment())


        }

    }
}