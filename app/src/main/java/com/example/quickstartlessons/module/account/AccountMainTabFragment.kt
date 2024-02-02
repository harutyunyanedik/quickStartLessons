package com.example.quickstartlessons.module.account

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.FragmentAccountMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.home.ui.viewModel.UsersViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccountMainTabFragment : BaseFragment() {

    private lateinit var binding: FragmentAccountMainTabBinding
    private val viewModel by viewModel<UsersViewModel>()
    private val args: AccountMainTabFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = args.id
        viewModel.getUserById(true, id)
    }

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
            findNavController().navigate(AccountMainTabFragmentDirections.actionGlobalPersonalDataFragment(args.id))
        }
    }

    @SuppressLint("SetTextI18n")
    private fun observeLiveData() {
        viewModel.userLiveData.observe(viewLifecycleOwner) {
            binding.userMail.text = it?.email
            binding.userName.text = it?.firstName + it?.lastName
            Glide.with(requireContext()).load(it?.image).into(binding.profileImage)
        }
        viewModel.userErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", it)
        }

    }
}