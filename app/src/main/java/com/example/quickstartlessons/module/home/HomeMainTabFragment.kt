package com.example.quickstartlessons.module.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.module.home.ui.viewModel.ProductsViewModel
import com.example.quickstartlessons.databinding.FragmentHomeMainTabBinding
import com.example.quickstartlessons.module.adapter.CategoriesRecyclerViewAdapter
import com.example.quickstartlessons.module.adapter.ProductsRecyclerViewAdapter
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.home.ui.viewModel.CategoriesViewModel
import com.example.quickstartlessons.module.products.data.response.model.CategoryModel

class HomeMainTabFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeMainTabBinding
    private val viewModel: ProductsViewModel by viewModels()
    private val viewModelCategory: CategoriesViewModel by viewModels()
    private var categoriesAdapter: CategoriesRecyclerViewAdapter = CategoriesRecyclerViewAdapter {
        binding.productsHeader.text = it
    }
    private var adapter: ProductsRecyclerViewAdapter = ProductsRecyclerViewAdapter {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getProducts()
        viewModelCategory.getCategories()
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
        setUpObservers()

    }

    private fun setupViews() {
        binding.rvItemsOfProducts.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvItemsOfProducts.adapter = adapter

        binding.rvItemOfCategories.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.rvItemOfCategories.adapter = categoriesAdapter
    }

    private fun setUpObservers() {
        viewModel.productsLiveData.observe(viewLifecycleOwner) {
            adapter.updateData(it?.products)
        }
        viewModel.productErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", "Unresolved error") // todo inchi hamar Unresolved error, it e henc qo errona
        }
        viewModelCategory.categoriesLiveData.observe(viewLifecycleOwner) {
            categoriesAdapter.updateData(it)
        }
        viewModelCategory.categoriesErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", "Unresolved error") // todo inchi hamar Unresolved error, it e henc qo errona
        }
    }
}
