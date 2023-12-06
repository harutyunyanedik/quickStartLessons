package com.example.quickstartlessons.android.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.quickstartlessons.android.base.BaseFragment
import com.example.quickstartlessons.databinding.FragmentImageViewBinding



class FragmentImageView : BaseFragment() {
    private lateinit var binding: FragmentImageViewBinding
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        url = arguments?.getString(IMAGE_URL)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageViewBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firsPageCheckBox.setOnClickListener {
            goBack()
        }
        Glide.with(this).load(url).into(binding.firstImage)
    }

    companion object {

        @JvmStatic
        fun newInstance(image: String) =
            FragmentImageView().apply {
                arguments = Bundle().apply {
                    putString(IMAGE_URL, image)
                }
            }

        const val IMAGE_URL = "imageUrl"
    }
}
