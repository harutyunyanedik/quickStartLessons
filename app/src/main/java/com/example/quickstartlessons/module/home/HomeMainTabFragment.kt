package com.example.quickstartlessons.module.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickstartlessons.databinding.ItemHomeMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.product.ProductAdapter
import com.example.quickstartlessons.module.product.ProductViewModel


class HomeMainTabFragment : BaseFragment() {
    private lateinit var binding: ItemHomeMainTabBinding
    private val adapter = ProductAdapter()
    private val viewModel: ProductViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemHomeMainTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupListener()
        setupObserve()


    }

    private fun setupRecyclerView() {

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun setupObserve() {
        viewModel.productLiveData.observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }
        viewModel.productErrorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupListener() {
        viewModel.getProduct()
    }
}