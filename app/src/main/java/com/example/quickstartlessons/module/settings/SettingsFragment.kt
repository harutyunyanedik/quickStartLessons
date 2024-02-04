package com.example.quickstartlessons.module.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentSettingsBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.base.utils.PreferencesManager

class SettingsFragment : BaseFragment() {

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
        binding.textViewChangeLanguage.setOnClickListener {
            val bottomSheetDialog = ChangeLanguageBottomSheetDialogFragment {

            }
            bottomSheetDialog.show(childFragmentManager, bottomSheetDialog.tag)
        }
        binding.textViewSettings.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.textViewChangeSignOut.setOnClickListener {
            PreferencesManager.putCurrentUserName(null)
            PreferencesManager.putCurrentPassword(null)
            findNavController().navigate(R.id.action_global_signInFragment)
        }
    }

}
