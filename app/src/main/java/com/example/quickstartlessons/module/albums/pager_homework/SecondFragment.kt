package com.example.quickstartlessons.module.albums.pager_homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.quickstartlessons.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment() {
    private val viewModel: ViewModel by viewModels()
    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sendPhone.setOnClickListener {
            viewModel.setValueToLiveData(binding.editPhone.text.toString())
        }
        setUpObservers()
    }
    private fun setUpObservers() {
        viewModel.liveData.observe(viewLifecycleOwner){ it ->
            binding.rememberText.text = it
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        fun newInstance() = SecondFragment()
    }
}