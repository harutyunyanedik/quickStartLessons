package com.example.quickstartlessons.module.albums.presentation.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickstartlessons.QuickStartApplication
import com.example.quickstartlessons.databinding.FragmentPhotosBinding
import com.example.quickstartlessons.module.albums.presentation.BaseFragment

class PhotosFragment : BaseFragment() {

    private lateinit var binding: FragmentPhotosBinding
    private val viewModel: PhotosViewModel by viewModels()
    private val adapter = PhotoAdapterAdapter {
        findNavController().navigate(PhotosFragmentDirections.actionPhotosFragmentToPhotoDetailFragment())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isNetworkAvailable()
        setupAdapter()
        setupListeners()
        setupObservers()
    }

    private fun setupListeners() {
        viewModel.getAlbums()
    }

    private fun setupObservers() {
        viewModel.albumLiveData.observe(viewLifecycleOwner) {
            adapter.updateAdapter(it)
        }

        viewModel.albumErrorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
    }

    private fun setupAdapter() {
        binding.rvPhotos.adapter = adapter
        binding.rvPhotos.layoutManager = GridLayoutManager(requireContext(), 2)

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