package com.example.quickstartlessons.module.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.core.room.FavoriteManager
import com.example.quickstartlessons.databinding.FragmentHomeMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.details.ProductDetailsFragmentDirections
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Locale

class HomeMainTabFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeMainTabBinding
    private val viewModel by viewModel<ProductsViewModel>()
    private val favoriteManager: FavoriteManager by inject()
    private val productsAdapter = ProductsAdapter (onClickItem = {
        findNavController().navigate(ProductDetailsFragmentDirections.actionDetailsFragment(it.id))

    }, favoriteUpdate = {isFavorite, product ->
        if (isFavorite) favoriteManager.insertProduct(product) else favoriteManager.deleteProduct(product.id)
    })
    private val categoriesAdapter = CategoriesAdapter {
        if (it == getString(R.string.products)) {
            viewModel.getProducts()
        } else {
            viewModel.getProductsByCategory(category = it)
        }
        binding.tvProducts.text = it.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
        }
    }

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
        observeLiveData()

    }

    private fun setupViews() {
        binding.rvProducts.adapter = productsAdapter
        binding.rvProducts.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvCategories.adapter = categoriesAdapter
        binding.rvCategories.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.searchImageView.setOnClickListener {
            findNavController().navigate(R.id.action_global_searchFragment)
        }
    }

    private fun observeLiveData() {
        viewModel.categoryLiveData.observe(viewLifecycleOwner) {
            categoriesAdapter.updateData(it)
        }

        viewModel.productLiveData.observe(viewLifecycleOwner) {
            productsAdapter.updateData(it)
        }

        favoriteManager.getAllProducts().observe(viewLifecycleOwner) {
            val favoritesId = it.map {productEntity -> productEntity.id}
            productsAdapter.updateFavorites(favoritesId)
        }

        viewModel.productErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error", it ?: "Unknown error")
        }
        viewModel.categoryErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error", it ?: "Unknown error")
        }

    }

}