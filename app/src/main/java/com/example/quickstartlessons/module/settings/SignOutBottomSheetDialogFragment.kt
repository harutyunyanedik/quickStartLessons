package com.example.quickstartlessons.module.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.databinding.FragmentSignOutBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SignOutBottomSheetDialogFragment(private val onClickButton: (Boolean) -> Unit) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSignOutBottomSheetDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignOutBottomSheetDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.buttonCancel.setOnClickListener {
            onClickButton.invoke(false)
            dismiss()
        }
        binding.buttonYes.setOnClickListener {
            onClickButton.invoke(true)
        }
    }
}