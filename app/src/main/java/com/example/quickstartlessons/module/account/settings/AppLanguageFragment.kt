package com.example.quickstartlessons.module.account.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentAppLanguageBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AppLanguageFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAppLanguageBinding
    private val adapter=AppLanguageAdapter{
        dismiss()
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


    private fun setupView(){
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        adapter.updateData(createNewList())

    }

    private fun createNewList():List<String>{
        val list= mutableListOf<String>()
        for (i in 0..2){
            list.add(listOf(getString(R.string.english)).toString())
            list.add(listOf(getString(R.string.russian)).toString())
            list.add(listOf(getString(R.string.armenian)).toString())
        }
        return list
    }


}