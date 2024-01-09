package com.example.quickstartlessons.module.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentLoginPageBinding

class LoginPageFragment : Fragment() {


    private lateinit var binding:FragmentLoginPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentLoginPageBinding.inflate(inflater,container, false)
        return binding.root
    }

}