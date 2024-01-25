package com.example.quickstartlessons.module.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetBinding
    private val adapter = LanguageAdapter {

    }
    private val languages = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBottomSheet()
    }

    private fun showBottomSheet() {
        binding.rvBottomSheet.adapter = adapter
        binding.rvBottomSheet.layoutManager = LinearLayoutManager(requireContext())
        adapter.updateDataLanguages(languagesList())
    }


    private fun languagesList(): List<String> {
        val list = mutableListOf<String>()
        for (i in 0..2) {
            list.add(listOf(getString(R.string.english_language)).toString())
            list.add(listOf(getString(R.string.russian_language)).toString())
            list.add(listOf(getString(R.string.armenian_language)).toString())
        }
        return list
    }


    companion object {
        @JvmStatic
        fun newInstance() = BottomSheetFragment()
    }
}