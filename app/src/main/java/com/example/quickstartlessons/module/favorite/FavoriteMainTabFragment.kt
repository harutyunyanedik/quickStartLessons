package com.example.quickstartlessons.module.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickstartlessons.core.room.FavoriteManager
import com.example.quickstartlessons.databinding.FragmentFavoriteMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.home.ui.HomeMainTabFragmentDirections
import com.example.quickstartlessons.module.home.ui.adapter.ProductsRecyclerViewAdapter
import com.example.quickstartlessons.module.products.data.response.model.products.ProductsDto
import org.koin.android.ext.android.inject

class FavoriteMainTabFragment : BaseFragment() {

    private lateinit var binding: FragmentFavoriteMainTabBinding
    private val favoriteManager: FavoriteManager by inject()
    private var adapter: ProductsRecyclerViewAdapter = ProductsRecyclerViewAdapter(onItemClick = {
        findNavController().navigate(HomeMainTabFragmentDirections.actionGlobalDescriptionFragment(it.id))
    }, updateFavorites = { isFavorite, product ->
        if (isFavorite) favoriteManager.insertProduct(product)  else favoriteManager.deleteProductById(product)
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteMainTabBinding.inflate(inflater, container, false)
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
    }

    private fun observeLiveData() {
        favoriteManager.getAllProducts().observe(viewLifecycleOwner) {
            val products = it.map { productEntity ->
               ProductsDto(
                    id = productEntity.id,
                    title = productEntity.title, price = productEntity.price,
                    description = productEntity.description, rating = productEntity.rating,
                    brand = productEntity.brand, category = productEntity.category, thumbnail = productEntity.thumbnail,
                 discountPercentage = "", images = mutableListOf("")
                )
            }
            val favoriteIds = it.map { productEntity -> productEntity.id }
            binding.favoriteText.isVisible = favoriteIds.isEmpty()
            adapter.updateFavorites(favoriteIds)
            adapter.updateData(products)
        }
    }
}