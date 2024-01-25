package com.example.quickstartlessons.module.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentBottomSheetBinding
import com.example.quickstartlessons.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDialog()
    }
    private fun showDialog(){
        binding.appLanguage.setOnClickListener{
            val dialog = BottomSheetFragment()
            dialog.show(childFragmentManager,"Show Dialog")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }
}