package com.example.quickstartlessons.module.albums.popuphomework.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.databinding.FragmentItemsBinding

class ItemsFragment : Fragment() {
    private lateinit var binding: FragmentItemsBinding
    private val adapter = ItemsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapters()
        
    }

    private fun setupAdapters() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        (requireActivity() as MainActivity).viewModel.itemsList.observe(viewLifecycleOwner) {
            adapter.updateAdapter(it)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ItemsFragment()
    }
}