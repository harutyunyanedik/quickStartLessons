package com.example.quickstartlessons.module.settings.languages


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.FragmentChooseLanguageBinding
import com.example.quickstartlessons.module.base.model.LocaleEnum
import com.example.quickstartlessons.module.base.model.SelectableData
import com.example.quickstartlessons.module.base.utils.LocaleSwitcher
import com.example.quickstartlessons.module.base.utils.PreferencesManager
import com.example.quickstartlessons.module.base.utils.homeActivity
import com.example.quickstartlessons.module.settings.languages.languageAdapter.ChooseLanguageRecyclerViewAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.Locale


class ChangeLanguageButtonSheetDialog(private var onItemClick: (String) -> Unit) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentChooseLanguageBinding
    private val languages = mutableListOf(LocaleEnum.ENGLISH, LocaleEnum.RUSSIAN, LocaleEnum.ARMENIAN)
    private var adapter: ChooseLanguageRecyclerViewAdapter = ChooseLanguageRecyclerViewAdapter {
        LocaleSwitcher.updateLocale(requireContext(), Locale(it.languageCode))
        homeActivity?.recreate()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseLanguageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.rvItemOfChooseLanguage.layoutManager = LinearLayoutManager(requireContext())
        binding.rvItemOfChooseLanguage.adapter = adapter
        val data = languages.map {
            SelectableData(data = it, isSelected = it.languageCode == PreferencesManager.getCurrentLanguage())
        }
        adapter.updateData(data)
    }
}