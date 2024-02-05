package com.example.quickstartlessons.module.account.users.personalData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.databinding.FragmentPersonalInfoBinding

class PersonalInfoFragment : Fragment() {

    private lateinit var binding: FragmentPersonalInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonalInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        QSApplication.usersLiveData.observe(viewLifecycleOwner) {
            val user = it
            with(binding) {
                userName.text = user?.firstName
                userLastName.text = user?.lastName
                userAge.text = user?.age.toString()
                userGender.text = user?.gender
                birthDayTv.text = user?.birthDate
                userPhone.text = user?.phone
                personalInformationTV.setOnClickListener {
                    findNavController().popBackStack()
                }
            }
        }
    }
}

