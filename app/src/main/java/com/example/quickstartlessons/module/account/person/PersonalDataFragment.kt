package com.example.quickstartlessons.module.account.person

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentPersonalDataBinding


class PersonalDataFragment : Fragment() {
    private lateinit var binding: FragmentPersonalDataBinding
    private val args: PersonalDataFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonalDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolBar.setOnClickListener {
            findNavController().navigateUp()
            setupPersonData()

        }
    }

    @SuppressLint("SetTextI18n")
    private fun setupPersonData() {
        binding.age.text = getString(R.string.age) +"։"+ args.age
        binding.birthDate.text = getString(R.string.birth_date) +"։"+ args.birthDate
        binding.gender.text = getString(R.string.gender) +"։"+ args.gender
        binding.phone.text = getString(R.string.phone) + "։"+args.phone
    }
}

