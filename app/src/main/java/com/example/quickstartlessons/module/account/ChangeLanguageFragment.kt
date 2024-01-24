package com.example.quickstartlessons.module.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentChangeLangugaeBinding

class ChangeLanguageFragment : DialogFragment() {
    private lateinit var binding:FragmentChangeLangugaeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentChangeLangugaeBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}