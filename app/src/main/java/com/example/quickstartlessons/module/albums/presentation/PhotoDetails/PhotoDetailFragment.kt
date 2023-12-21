package com.example.quickstartlessons.module.albums.presentation.PhotoDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.quickstartlessons.QuickStartApplication
import com.example.quickstartlessons.databinding.FragmentPhotoDetailBinding
import com.example.quickstartlessons.module.albums.presentation.BaseFragment

class PhotoDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentPhotoDetailBinding
    private val args by navArgs<PhotoDetailFragment>()
    private val viewModel: PhotosDetailViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotoDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isNetworkAvailable()
        viewModel.getAlbums(id = args.id)
        setupObservers()

    }

    private fun setupObservers() {
        viewModel.albumLiveData.observe(viewLifecycleOwner) {
            binding.photoDetailsTitle.text = it?.title
            Glide.with(requireContext()).load(it?.url).into(binding.photoDetailsImage)
        }

        viewModel.albumErrorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
    }


    private fun isNetworkAvailable() {
      QuickStartApplication.networkStateLiveData.observe(requireActivity()) {
            if (it) {
                Toast.makeText(requireContext(), "Internet is connected", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), "No internet connection", Toast.LENGTH_LONG).show()
            }
        }
    }

}