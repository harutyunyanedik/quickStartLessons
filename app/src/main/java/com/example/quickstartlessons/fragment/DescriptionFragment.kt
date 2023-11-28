package com.example.quickstartlessons.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.quickstartlessons.MAIN
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.base.BaseFragment
import com.example.quickstartlessons.databinding.FragmentDescriptionBinding
import com.example.quickstartlessons.databinding.FragmentGeneralBinding


class DescriptionFragment : BaseFragment() {

    private lateinit var binding: FragmentDescriptionBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnWdFQDu2akH8YestwlhyQJNKgKY0C9jLshNe8QF1ZkOS2MrHq0XmFP_RgamyJDarj8ws&usqp=CAU"
        binding.icNavigateBack.setOnClickListener {
           goBack()
        }
        Glide.with(this).load(image).into(binding.descrtptionFragmentImage)
    }

    companion object {
        @JvmStatic
        fun newInstance() = DescriptionFragment()
    }
}