package com.example.quickstartlessons.android.ftagments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.quickstartlessons.android.base.BaseFragment
import com.example.quickstartlessons.databinding.FragmentSecondBinding

class NewsDescriptionFragment : BaseFragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backClick.setOnClickListener {
            goBack()
        }

         val value = NewsFragment().param1
        Glide.with(this).load(value).into(binding.imageSecondFragment)
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewsDescriptionFragment()
    }
}