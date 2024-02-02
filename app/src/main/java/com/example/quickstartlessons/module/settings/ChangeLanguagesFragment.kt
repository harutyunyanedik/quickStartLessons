package com.example.quickstartlessons.module.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.quickstartlessons.databinding.FragmentLanguagesBinding
import com.example.quickstartlessons.module.base.model.LocaleEnum
import com.example.quickstartlessons.module.base.model.SelectableData
import com.example.quickstartlessons.module.base.utils.LocaleSwitcher
import com.example.quickstartlessons.module.base.utils.PreferencesManager
import com.example.quickstartlessons.module.base.utils.homeActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.Locale


class ChangeLanguagesFragment(private val selectedLanguage: (String) -> Unit) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentLanguagesBinding
    private val languages = mutableListOf(LocaleEnum.ENGLISH, LocaleEnum.RUSSIAN, LocaleEnum.ARMENIAN)
    private val adapter = LanguageAdapter {
        LocaleSwitcher.updateLocale(requireContext(), Locale(it.languageCode))
        homeActivity?.recreate()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLanguagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews() {
        binding.rvLanguages.adapter = adapter
        binding.rvLanguages.layoutManager = LinearLayoutManager(requireContext())
        val data = languages.map {
            SelectableData(data = it, isSelected = it.languageCode == PreferencesManager.getCurrentLanguage())
        }
        adapter.updateDataLanguages(data)
    }
}