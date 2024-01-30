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
import com.example.quickstartlessons.module.details.ProductDetailsFragmentDirections
import com.example.quickstartlessons.module.home.ProductsAdapter
import com.example.quickstartlessons.module.product.data.model.Product
import org.koin.android.ext.android.inject

class FavoriteMainTabFragment : BaseFragment() {

    private val favoriteManager: FavoriteManager by inject()
    private lateinit var binding: FragmentFavoriteMainTabBinding
    private val productsAdapter = ProductsAdapter (onClickItem = {
        findNavController().navigate(ProductDetailsFragmentDirections.actionDetailsFragment(it.id))

    }, favoriteUpdate = {isFavorite, product ->
        if (isFavorite) favoriteManager.insertProduct(product) else favoriteManager.deleteProduct(product.id)
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
        binding.rvFavoritesProducts.adapter = productsAdapter
        binding.rvFavoritesProducts.layoutManager = GridLayoutManager(requireContext(), 2)

    }
    private fun observeLiveData() {
        favoriteManager.getAllProducts().observe(viewLifecycleOwner) {
            val products = it.map { productEntity ->
                Product(
                    id = productEntity.id,
                    title = productEntity.title,
                    description = productEntity.description,
                    price = productEntity.price,
                    imageUrl = productEntity.imageUrl
                )
            }
            productsAdapter.updateData(products)
            val favoritesId = it.map {productEntity -> productEntity.id}
            productsAdapter.updateFavorites(favoritesId)
        }
    }
}