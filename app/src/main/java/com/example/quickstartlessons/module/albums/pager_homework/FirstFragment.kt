package com.example.quickstartlessons.module.albums.pager_homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.quickstartlessons.QuickStartApplication
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentFirstBinding
import com.example.quickstartlessons.module.albums.presentation.AlbumViewModel

class FirstFragment : BaseFragment() {

    private val viewModel: ViewModel by viewModels()
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sendEmail.setOnClickListener {
           viewModel.setValueToLiveData(binding.editEmail.text.toString())
        }
        setUpObservers()
    }
    private fun setUpObservers() {
        viewModel.liveData.observe(viewLifecycleOwner) { it ->
            binding.rememberText.text = it
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        fun newInstance() = FirstFragment()
    }
}