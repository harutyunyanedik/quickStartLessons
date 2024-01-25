package com.example.quickstartlessons.module.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.ButtomLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomFragment(): BottomSheetDialogFragment(){

    private lateinit var binding: ButtomLayoutBinding
    private val languages = mutableListOf<String>()
    private val adapter = LanguagesAdapter {

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = ButtomLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createLanguages()
        setupViews()
    }

    private fun setupViews() {
        binding.rvLanguages.adapter = adapter
        binding.rvLanguages.layoutManager = LinearLayoutManager(requireContext())
        adapter.updateData(languages)

    }
    private fun createLanguages() {
        languages.add("English")
        languages.add("Armenian")
        languages.add("Russian")
        languages.add("Espanol")
        languages.add("Francais")
        languages.add("Deutsch")
        languages.add("Polski")
        languages.add("Ukrainian")
    }

}