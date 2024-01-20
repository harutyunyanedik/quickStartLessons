package com.example.quickstartlessons.module.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.FragmentHomeMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.home.CategoriesAdapter
import com.example.quickstartlessons.module.home.ui.adapters.ProductsAdapter
import com.example.quickstartlessons.module.home.ui.viewmodel.HomeMainTabViewModel


class HomeMainTabFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeMainTabBinding
    private val adapter = ProductsAdapter()
    private val categoriesAdapter = CategoriesAdapter { category ->
        viewModel.getProductsByCategory(true, category)
    }
    private val viewModel: HomeMainTabViewModel by viewModels()
    private val categoriesViewModel: HomeMainTabViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeMainTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getProducts()
        categoriesViewModel.getCategories()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeLivedata()
    }

    private fun setupViews() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvCategories.adapter = categoriesAdapter
        binding.rvCategories.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    private fun observeLivedata() {
        viewModel.productLiveData.observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }
        viewModel.productErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", it ?: "Unknown error")
        }
        categoriesViewModel.categoryLiveDataCategory.observe(viewLifecycleOwner) {
            categoriesAdapter.updateDataCategories(it)
        }

        categoriesViewModel.categoryErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", it ?: "Unknown error")
        }
    }
}