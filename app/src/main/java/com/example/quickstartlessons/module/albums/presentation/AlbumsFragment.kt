package com.example.quickstartlessons.module.albums.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.quickstartlessons.databinding.FragmentAlbumsBinding

//class AlbumsFragment : Fragment() {
//
//    private lateinit var binding: FragmentAlbumsBinding
//    private val viewModel: AlbumViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentAlbumsBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setupListeners()
//        setupObservers()
//    }
//
//    private fun setupListeners() {
//        binding.httpRequestButton.setOnClickListener {
//            viewModel.getAlbums()
//        }
//    }
//
//    private fun setupObservers() {
//        viewModel.albumLiveData.observe(viewLifecycleOwner) {
//            binding.albumTitle.text = it?.title
//        }
//
//        viewModel.albumErrorLiveData.observe(viewLifecycleOwner) {
//            // show dialog
//        }
//    }
//
//    companion object {
//        @JvmStatic
//        fun newInstance() = AlbumsFragment()
//    }
//}