package com.example.quickstartlessons.module.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentSettingsBinding
import com.example.quickstartlessons.module.base.utils.PreferencesManager

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.appLanguage.setOnClickListener {
            val bottomSheetDialog = ChangeLanguagesFragment {
            }
            bottomSheetDialog.show(childFragmentManager, bottomSheetDialog.tag)
        }
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.textViewChangeSignOut.setOnClickListener {
            PreferencesManager.putCurrentUserName(null)
            PreferencesManager.putCurrentPassword(null)
            findNavController().navigate(R.id.action_global_signInFragment)
        }
    }
    }
}
