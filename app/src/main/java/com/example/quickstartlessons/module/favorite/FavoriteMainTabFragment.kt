package com.example.quickstartlessons.module.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickstartlessons.core.room.FavoriteManager
import com.example.quickstartlessons.databinding.FragmentFavoriteMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.home.ui.adapters.ProductsAdapter
import com.example.quickstartlessons.module.products.data.ProductDto
import com.example.quickstartlessons.module.products.details.ProductDetailsFragmentDirections
import org.koin.android.ext.android.inject

class FavoriteMainTabFragment : BaseFragment() {
    private lateinit var binding: FragmentFavoriteMainTabBinding
    private val favoriteManager: FavoriteManager by inject()
    private val adapter = ProductsAdapter(onClickItem = {
        findNavController().navigate(ProductDetailsFragmentDirections.actionProductDetailsFragment(it.id))
    }, updateFavorite = { isFavorite, product ->
        if (isFavorite) favoriteManager.insertProduct(product) else favoriteManager.deleteProductByID(product)
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
        observeLivedata()
    }

    private fun setupViews() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun observeLivedata() {
        favoriteManager.getAllProducts().observe(viewLifecycleOwner) {
            val favoriteIds = it.map { productEntity -> productEntity.id }
            val products = it.map {productEntity->
                ProductDto(
                    id = productEntity.id,
                    title = productEntity.title,
                    description = productEntity.description,
                    price = productEntity.price,
                    imageUrl = productEntity.imageUrl,
                    images = mutableListOf("")
                )
            }
            adapter.updateData(products)
            adapter.updateFavorites(favoriteIds)
        }
    }
}