package com.example.quickstartlessons.module.account.settings.languages


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.FragmentChooseLanguageBinding
import com.example.quickstartlessons.module.account.settings.languages.adapter.ChooseLanguageRecyclerViewAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ChooseLanguageFragment(private var onItemClick: (String) -> Unit) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentChooseLanguageBinding
    private var adapter: ChooseLanguageRecyclerViewAdapter = ChooseLanguageRecyclerViewAdapter {
        onItemClick.invoke(it)
        dismiss()
    }

    private val items: MutableList<String> = mutableListOf(" English", " Հայերեն", " Русский")

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
        adapter.updateData(items)
    }
}