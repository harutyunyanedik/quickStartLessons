package com.example.quickstartlessons.tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentBaseBinding
import com.example.quickstartlessons.databinding.FragmentFirstBinding

class FragmentFirst :Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentFirstBinding.inflate(inflater, container,false)

        return binding.root
    }
    companion object {
        fun newInstance() = FragmentSecond()

    }
}