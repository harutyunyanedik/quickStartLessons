package com.example.quickstartlessons.module.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickstartlessons.core.room.FavoriteManager
import com.example.quickstartlessons.databinding.FragmentSearchBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.home.ui.adapter.ProductsRecyclerViewAdapter
import com.example.quickstartlessons.module.search.viewModel.SearchViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchFragment : BaseFragment() {
    private lateinit var binding: FragmentSearchBinding
    private val viewModel by viewModel<SearchViewModel>()
    private val favoriteManager: FavoriteManager by inject()

    private var adapter: ProductsRecyclerViewAdapter = ProductsRecyclerViewAdapter(onItemClick = {
        findNavController().navigate(SearchFragmentDirections.actionGlobalDescriptionFragment(it.id))
    }, updateFavorites = { isFavorite, product ->
        if (isFavorite) favoriteManager.insertProduct(product) else favoriteManager.deleteProductById(product)
    })


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
        setupViews()
        observeLiveData()
    }

    private fun setupViews() {
        favoriteManager.getAllProducts().observe(viewLifecycleOwner) {
            binding.rvItemOfProducts.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.rvItemOfProducts.adapter = adapter

        }
    }

    private fun observeLiveData() {
        viewModel.searchProductsLiveData.observe(viewLifecycleOwner) {
            adapter.updateData(it?.products)
            binding.resultText.isVisible = binding.searchText.text.toString().isEmpty()
        }
        viewModel.searchProductsErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", it)
        }
        favoriteManager.getAllProducts().observe(viewLifecycleOwner) {
            adapter.updateFavorites(it.map { productEntity ->
                productEntity.id
            })
        }
    }

    private fun setUpListeners() {
        binding.searchText.doAfterTextChanged {

            it?.length?.let { length ->
                if (length > 2) {
                    viewModel.search(name = it.toString())
                }
            }
        }
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}