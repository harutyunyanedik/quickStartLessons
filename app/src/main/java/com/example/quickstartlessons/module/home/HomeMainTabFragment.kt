package com.example.quickstartlessons.module.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.module.home.ui.viewModel.HomeMainTabViewModel
import com.example.quickstartlessons.databinding.FragmentHomeMainTabBinding
import com.example.quickstartlessons.module.home.ui.viewModel.adapter.CategoriesRecyclerViewAdapter
import com.example.quickstartlessons.module.home.ui.viewModel.adapter.ProductsRecyclerViewAdapter
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import java.util.Locale

class HomeMainTabFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeMainTabBinding
    private val viewModel: HomeMainTabViewModel by viewModels()
    private var categoriesAdapter: CategoriesRecyclerViewAdapter = CategoriesRecyclerViewAdapter{ it, n->
        if(n % 2 != 1) {
            binding.productsHeader.text = it.toLowerCase(Locale.ROOT).replaceFirstChar {
                it.titlecase(Locale.getDefault())
            }
            viewModel.getProductsByCategory(true, categoryName = it)
        }else {
            viewModel.getProducts()
           binding.productsHeader.text = "All products"

        }
    }
    private var adapter: ProductsRecyclerViewAdapter = ProductsRecyclerViewAdapter {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getProducts()
        viewModel.getCategories()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeMainTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeLiveData()
    }

    private fun setupViews() {
        binding.rvItemsOfProducts.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvItemsOfProducts.adapter = adapter

        binding.rvItemOfCategories.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.rvItemOfCategories.adapter = categoriesAdapter
    }

    private fun observeLiveData() {
        viewModel.productsLiveData.observe(viewLifecycleOwner) {
            adapter.updateData(it?.products)
        }
        viewModel.productErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", it)
        }
        viewModel.productsByCategoryLiveData.observe(viewLifecycleOwner) {
            adapter.updateData(it?.products)
        }
        viewModel.productsByCategoryErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", it)
        }
        viewModel.categoriesLiveData.observe(viewLifecycleOwner) {
            categoriesAdapter.updateData(it)
        }
        viewModel.categoriesErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", it)
        }
    }
}
