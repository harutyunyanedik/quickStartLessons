package com.example.quickstartlessons.module.home.ui.serch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
   private lateinit var binding:FragmentSearchBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding=FragmentSearchBinding.inflate(inflater,container, false)
        return binding.root
    }




}