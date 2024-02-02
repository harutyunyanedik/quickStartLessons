package com.example.quickstartlessons.module.account.personalData

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.FragmentPersonalDataBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.home.ui.viewModel.UsersViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonalDataFragment : BaseFragment() {
    private lateinit var binding: FragmentPersonalDataBinding
    private val viewModel by viewModel<UsersViewModel>()
    private val args: PersonalDataFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getUserById(true, args.id)
    }

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
        viewModel.userLiveData.observe(viewLifecycleOwner) {
            binding.userMail.text = it?.email
            binding.userName.text = it?.firstName + it?.lastName
            binding.birthDate.text = it?.birthDate
            binding.gender.text = it?.gender
            binding.phone.text = it?.phone
            Glide.with(requireContext()).load(it?.image).into(binding.profileImage)
        }
        viewModel.userErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", it)
        }
    }
}
