package com.example.quickstartlessons.module.albums.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.quickstartlessons.databinding.FragmentHttpBinding

class HttpFragment : Fragment() {

    private lateinit var binding: FragmentHttpBinding
    private val albumViewModel: AlbumViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHttpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupObservers()
    }

    private fun setupListeners() {
        binding.httpRequestButton.setOnClickListener {
            albumViewModel.getAlbums()
        }
    }

    private fun setupObservers() {
        albumViewModel.albumLiveData.observe(viewLifecycleOwner) {
            binding.albumTitle.text = it?.title
        }

        albumViewModel.albumErrorLiveData.observe(viewLifecycleOwner) {
            // show dialog
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HttpFragment()
    }
}