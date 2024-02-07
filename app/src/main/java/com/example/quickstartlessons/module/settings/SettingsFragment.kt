package com.example.quickstartlessons.module.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.databinding.FragmentSettingsBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.base.utils.PreferencesManager
import com.example.quickstartlessons.module.base.utils.homeActivity
import com.example.quickstartlessons.module.launch.SplashActivity
import com.example.quickstartlessons.module.settings.languages.ChangeLanguageButtonSheetDialog

class SettingsFragment : BaseFragment() {

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

        binding.signOut.setOnClickListener {
            PreferencesManager.removePassword()
            PreferencesManager.removeUserName()
            startActivity(Intent(requireContext(), SplashActivity::class.java))
            homeActivity?.finish()
        }
    }

    private fun showBottomSheetDialog() {
        val chooseLanguageFragment = ChangeLanguageButtonSheetDialog {
        }
        chooseLanguageFragment.show(childFragmentManager, chooseLanguageFragment.tag)
    }
}

