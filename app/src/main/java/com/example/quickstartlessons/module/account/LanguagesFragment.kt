package com.example.quickstartlessons.module.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.quickstartlessons.databinding.FragmentLanguagesBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class LanguagesFragment(private val onItemClick: (String) -> Unit) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentLanguagesBinding
    private val languages = mutableListOf<String>()
    private val adapter = LanguageAdapter {
        onItemClick.invoke(it)
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
        binding.rvBottomSheet.adapter = adapter
        binding.rvBottomSheet.layoutManager = LinearLayoutManager(requireContext())
        adapter.updateDataLanguages(languages)
    }

    private fun createLanguages() {
        languages.add("Հայերեն")
        languages.add("Русский")
        languages.add("English")
        languages.add("Français")
    }

}