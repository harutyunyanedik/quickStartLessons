package com.example.quickstartlessons.module.signin.signout

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
        binding.cancelButton.setOnClickListener {
            onClickButton.invoke(false)
            dismiss()
        }
        binding.yesButton.setOnClickListener {
            onClickButton.invoke(true)
        }
    }
}