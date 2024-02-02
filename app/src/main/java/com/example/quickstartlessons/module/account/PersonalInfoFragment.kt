package com.example.quickstartlessons.module.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quickstartlessons.databinding.FragmentPersonalInfoBinding

class PersonalInfoFragment : Fragment() {

    private lateinit var binding: FragmentPersonalInfoBinding
    private val args: PersonalInfoFragmentArgs by navArgs()

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
        val user = args.id
        with(binding) {
            userName.text = user.name
            userLastName.text = user.lastName
            userAge.text = user.age.toString()
            userGender.text = user.gender
            birthDayTv.text = user.birthDate
            userPhone.text = user.phone
            personalInformationTV.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}

