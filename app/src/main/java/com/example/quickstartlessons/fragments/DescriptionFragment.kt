package com.example.quickstartlessons.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.FragmentDescriptionBinding

class DescriptionFragment : Fragment() {

    private lateinit var binding: FragmentDescriptionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        binding.imageViewBack.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
    }

    private fun setupViews() {
        val args = arguments
        with(binding) {
            textViewDescriptionTitle.text = args?.getString(TITLE)
            textViewDescriptionDate.text = args?.getString(DATE)
            Glide.with(requireContext()).load(args?.getString(IMAGE_URL)).into(imageViewDescription)
            textViewDescription.text = args?.getString(DESCRIPTION)
        }
    }

    companion object {

        private const val TITLE = "title"
        private const val DATE = "date"
        private const val IMAGE_URL = "image_url"
        private const val DESCRIPTION = "description"

        @JvmStatic
        fun newInstance(title: String, date: String, imageUrl: String, description: String) =
            DescriptionFragment().apply {
                arguments = Bundle().apply {
                    putString(TITLE, title)
                    putString(DATE, date)
                    putString(IMAGE_URL, imageUrl)
                    putString(DESCRIPTION, description)
                }
            }

    }
}