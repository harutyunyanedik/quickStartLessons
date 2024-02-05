package com.example.quickstartlessons.module.personalinformation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.databinding.FragmentPersonalInformationBinding

class PersonalInformationFragment : Fragment() {

    private lateinit var binding: FragmentPersonalInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonalInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        QSApplication.userLiveData.observe(viewLifecycleOwner) {
            val user = it
            with(binding){
                userNameTv.text = user?.firstName
                userLastNameTv.text = user?.lastName
                userAgeTv.text = user?.age.toString()
                userGenderTv.text = user?.gender
                userBirthDayTv.text = user?.birthDate
                userPhoneTv.text = user?.phone
                personalInformationTV.setOnClickListener {
                    findNavController().popBackStack()
                }
            }
        }

    }

}