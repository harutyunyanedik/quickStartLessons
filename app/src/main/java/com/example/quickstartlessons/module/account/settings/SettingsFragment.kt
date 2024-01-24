package com.example.quickstartlessons.module.account.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentSettingsBinding
import com.example.quickstartlessons.databinding.FragmentSignInBinding

class SettingsFragment : Fragment() {

private lateinit var binding:FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSettingsBinding.inflate(inflater,container,false)
     return   binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    binding.toolBar.navigationIcon

        binding.language.setOnClickListener {


        }
    }
    private fun showDialog(){
        val dialog=AppLanguageFragment()
        dialog.show(childFragmentManager,"Show Dialog")
    }

}
