package com.example.quickstartlessons.android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentEqualButtonBinding

class FragmentEqualButton(): Fragment() {
    private lateinit var binding: FragmentEqualButtonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEqualButtonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.equalButton.text="0"

    }
    fun incrementCount(){
        var count=binding.equalButton.text.toString().toInt()
        val newCount=count+1
        binding.equalButton.text=newCount.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentEqualButton()



    }
}