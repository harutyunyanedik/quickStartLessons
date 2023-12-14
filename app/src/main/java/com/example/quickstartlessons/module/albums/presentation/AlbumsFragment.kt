package com.example.quickstartlessons.module.albums.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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
    }

    private fun setupListeners() {
        binding.httpRequestButton.setOnClickListener {
            if(isOnline(requireContext())){
                viewModel.getAlbums()
            }else{
                Toast.makeText(requireContext(),"Disconnected",Toast.LENGTH_SHORT).show()
            }

        }
        binding.navigateToDetailsButton.setOnClickListener {
            //findNavController().navigate(R.id.action_albumsFragment_to_albumDatailsFragment)
            findNavController().navigate(AlbumsFragmentDirections.actionAlbumsFragmentToAlbumDatailsFragment("1"))
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
    @SuppressLint("NewApi", "MissingPermission")
    fun isOnline(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false

        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    }
}