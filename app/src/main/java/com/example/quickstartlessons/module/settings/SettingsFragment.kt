package com.example.quickstartlessons.module.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.QSApplication
import com.example.quickstartlessons.databinding.FragmentSettingsBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.base.utils.PreferencesManager.getUserNameFromPref
import com.example.quickstartlessons.module.base.utils.PreferencesManager.getUserPasswordFromPref
import com.example.quickstartlessons.module.base.utils.Prefs
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
                if (QSApplication.usersProfile.value != null) {
                    val deletePassword = QSApplication.usersProfile.value?.password
                    val deleteUsername = QSApplication.usersProfile.value?.username

                    if (deletePassword == getUserPasswordFromPref()) getUserPasswordFromPref().removeRange(0..2)
                    if (deleteUsername == getUserNameFromPref()) getUserNameFromPref().removeRange(0..2)
                    QSApplication.usersProfile.value = null

                    findNavController().navigate(SettingsFragmentDirections.actionGlobalSignInFragment())
                }
        }
    }

    private fun showBottomSheetDialog() {
        val chooseLanguageFragment = ChangeLanguageButtonSheetDialog {

        }
        chooseLanguageFragment.show(childFragmentManager, chooseLanguageFragment.tag)
    }
}

