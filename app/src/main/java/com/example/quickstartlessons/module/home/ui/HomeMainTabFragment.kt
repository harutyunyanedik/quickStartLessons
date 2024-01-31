package com.example.quickstartlessons.module.home.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.core.room.FavoriteManager
import com.example.quickstartlessons.databinding.FragmentHomeMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.home.CategoriesAdapter
import com.example.quickstartlessons.module.home.ui.adapters.ProductsAdapter
import com.example.quickstartlessons.module.home.ui.viewmodel.HomeMainTabViewModel
import com.example.quickstartlessons.module.products.details.ProductDetailsFragmentDirections
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeMainTabFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeMainTabBinding
    private val favoriteManager: FavoriteManager by inject()
    private val adapter = ProductsAdapter(onClickItem = {
        findNavController().navigate(ProductDetailsFragmentDirections.actionProductDetailsFragment(it.id))
    }, updateFavorite = { isFavorite, product ->
        if (isFavorite) favoriteManager.insertProduct(product) else favoriteManager.deleteProduct(product)

    })

    @SuppressLint("ResourceType")
    private val categoriesAdapter = CategoriesAdapter { category ->
        if (category == getString(R.string.products)) {
            viewModel.getProducts()
        } else {
            viewModel.getProductsByCategory(true, category)
        }
        binding.products.text = category.replaceFirstChar {
            if (it.isLowerCase()) {
                it.titlecase()
            } else it.toString()

        }
    }

    private val viewModel by viewModel<HomeMainTabViewModel>()

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
        viewModel.getCategories()
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
        viewModel.categoryLiveDataCategory.observe(viewLifecycleOwner) {
            val list = mutableListOf<String>()
            list.add("All products")
            if (it != null) {
                list.addAll(it)
            }
            categoriesAdapter.updateDataCategories(list)
        }

        viewModel.categoryErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", it ?: "Unknown error")
        }

        favoriteManager.getAllProducts().observe(viewLifecycleOwner) {
            val favoriteIds = it.map { productEntity -> productEntity.id }
            adapter.updateFavorites(favoriteIds)
        }
    }
}