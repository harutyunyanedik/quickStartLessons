package com.example.quickstartlessons.module.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.databinding.FragmentSettingsBinding
import com.example.quickstartlessons.module.settings.languages.ChangeLanguageButtonSheetDialog

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.appLanguage.setOnClickListener {
            showBottomSheetDialog()
        }
    }

    private fun showBottomSheetDialog(){
            val chooseLanguageFragment = ChangeLanguageButtonSheetDialog{

            }
            chooseLanguageFragment.show(childFragmentManager, chooseLanguageFragment.tag)
        }

}