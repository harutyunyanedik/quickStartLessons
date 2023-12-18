package com.example.quickstartlessons.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickstartlessons.QuickStartApplication
import com.example.quickstartlessons.databinding.ItemPhotoFragmentBinding

class FragmentPhoto : Fragment() {

    private lateinit var binding: ItemPhotoFragmentBinding
    private val photoViewModel: ViewModelPhoto by viewModels()
    private val adapter = AdapterPhoto {
        findNavController().navigate(FragmentPhotoDirections.actionFragmentPhotoToFragmentNavigate(it))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ItemPhotoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupListeners()
        setupObservers()
        setupListenerInternetConnection()
    }

    private fun setupViews() {
        binding.recyclerViewPhoto.adapter = adapter
        binding.recyclerViewPhoto.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun setupListeners() {
        photoViewModel.getPhoto()
    }

    private fun setupObservers() {
        photoViewModel.photoLiveData.observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }
        photoViewModel.errorPhotoLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupListenerInternetConnection() {
        QuickStartApplication.networkStateLiveData.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(requireContext(), "Connected", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Not connected", Toast.LENGTH_SHORT).show()
            }
        }
    }
}



