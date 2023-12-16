package com.example.quickstartlessons.module.albums.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.quickstartlessons.databinding.FragmentPhotosBinding

class PhotosFragment : Fragment() {
    private lateinit var binding: FragmentPhotosBinding
    private val viewModel: PhotoViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPhotosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    companion object {

        @JvmStatic
        fun newInstance() = PhotosFragment()
    }
}