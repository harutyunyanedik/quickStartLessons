package com.example.quickstartlessons.module.account.settings

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentAppLanguageBinding
import com.example.quickstartlessons.module.account.settings.adapter.AppLanguageAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AppLanguageFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAppLanguageBinding
    private val adapter = AppLanguageAdapter {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAppLanguageBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }


    private fun setupView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter.updateData(createNewList())

    }

    @SuppressLint("ResourceType")
    private fun createNewList(): List<String> {
        val list = mutableListOf<String>()
        list.addAll(listOf(getString(R.string.english), getString(R.string.russian), getString(R.string.armenian))).toString()
        return list
    }


}