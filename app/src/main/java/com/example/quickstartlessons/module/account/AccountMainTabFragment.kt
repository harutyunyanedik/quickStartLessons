package com.example.quickstartlessons.module.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.databinding.FragmentAccountMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment

class AccountMainTabFragment : BaseFragment() {

    private lateinit var binding: FragmentAccountMainTabBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding= FragmentAccountMainTabBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.notification.setOnCheckedChangeListener { compoundButton, b ->

        }

        binding.settings.setOnCheckedChangeListener { compoundButton, b ->


        }
    }

}