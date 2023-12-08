package com.example.quickstartlessons.android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentPlusButtonBinding

class FragmentPlusButton (private val onClickButton:()->Unit): Fragment() {
private lateinit var binding:FragmentPlusButtonBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentPlusButtonBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.plusButton.setOnClickListener {
          onClickButton.invoke()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance(onClickButton: () -> Unit) = FragmentPlusButton(onClickButton)
    }
}