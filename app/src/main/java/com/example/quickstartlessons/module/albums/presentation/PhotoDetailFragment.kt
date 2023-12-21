package com.example.quickstartlessons.module.albums.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.quickstartlessons.databinding.FragmentPhotoDetailBinding

class PhotoDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentPhotoDetailBinding
    private val args by navArgs<PhotoDetailFragmentArgs>()
    private val viewModel: AlbumDetailViewModel by viewModels()


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
            binding.textViewTitleDetail.text = it?.title
            Glide.with(requireContext()).load(it?.url).into(binding.imageViewDetail)
        }

        viewModel.albumErrorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
    }


    private fun isNetworkAvailable() {
        QuickstartApplication.networkStateLiveData.observe(requireActivity()) {
            if (it) {
                Toast.makeText(requireContext(), "Internet is connected", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), "No internet connection", Toast.LENGTH_LONG).show()
            }
        }
    }

}