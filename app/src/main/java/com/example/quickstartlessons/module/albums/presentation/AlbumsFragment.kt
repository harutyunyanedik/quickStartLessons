package com.example.quickstartlessons.module.albums.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.QuickStartApplication
import com.example.quickstartlessons.databinding.FragmentAlbumsBinding

class AlbumsFragment : Fragment() {

    private lateinit var binding: FragmentAlbumsBinding
    private val viewModel: AlbumViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupObservers()
      setupListenerInternetConnection()
    }

    private fun setupListeners() {
        binding.httpRequestButton.setOnClickListener {
            viewModel.getAlbums()
        }

        binding.navigateToDetailsButton.setOnClickListener {
            findNavController().navigate(AlbumsFragmentDirections.actionAlbumsFragmentToAlbumDetailsFragment("10", "11"))
        }
    }
    private fun setupListenerInternetConnection() {
        QuickStartApplication.networkStateLiveData.observe(viewLifecycleOwner){
            if(it){
                Toast.makeText(requireContext(),"Connected", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(),"Not connected", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun setupObservers() {
        viewModel.albumLiveData.observe(viewLifecycleOwner) {

            binding.albumTitle.text = it?.title
        }

        viewModel.albumErrorLiveData.observe(viewLifecycleOwner) {
            // show dialog
        }
    }
}