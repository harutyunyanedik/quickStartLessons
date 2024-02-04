package com.example.quickstartlessons.module.home

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
import com.example.quickstartlessons.module.details.ProductDetailsFragmentDirections
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment() {

    private lateinit var binding: FragmentSearchBinding
    private val favoriteManager: FavoriteManager by inject()
    private val viewModel: SearchedProductsViewModel by viewModel()
    private val productsAdapter = ProductsAdapter (onClickItem = {
        findNavController().navigate(ProductDetailsFragmentDirections.actionDetailsFragment(it.id))

    }, favoriteUpdate = {isFavorite, product ->
        if (isFavorite) favoriteManager.insertProduct(product) else favoriteManager.deleteProduct(product.id)
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeLiveData()
        setupListeners()
    }

    private fun setupViews(){
        binding.rvSearchedProducts.adapter = productsAdapter
        binding.rvSearchedProducts.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun setupListeners() {
        binding.imageViewSearchBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.editTextSearch.doAfterTextChanged {
            viewModel.getSearchedProductsByName(name=it.toString())
        }
    }

    private fun observeLiveData() {
        viewModel.searchedProductsLiveData.observe(viewLifecycleOwner) {
            productsAdapter.updateData(it)
            binding.noResultTV.isVisible = it == null
        }
    }

}