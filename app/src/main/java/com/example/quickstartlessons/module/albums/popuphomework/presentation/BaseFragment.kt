package com.example.quickstartlessons.module.albums.popuphomework.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentBaseBinding
import com.example.quickstartlessons.module.albums.popuphomework.data.ItemsData


class BaseFragment : Fragment() {

    private lateinit var binding: FragmentBaseBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.addUser.setOnClickListener {
            val country = binding.countryTitle.text.toString()
            val name = binding.nameTitle.text.toString()
            val surname = binding.surnameTitle.text.toString()
            if (name.isNotEmpty() && surname.isNotEmpty()) {
                (requireActivity() as MainActivity).viewModel.addItems(ItemsData(country,name, surname))
                findNavController().navigate(R.id.action_baseFragment_to_itemsFragment)
            } else {
                Toast.makeText(requireContext(), " Please.enter your full credentials", Toast.LENGTH_LONG).show()
            }
        }

    }


    companion object {
        @JvmStatic
        fun newInstance() = BaseFragment()
    }
}