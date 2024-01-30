package com.example.quickstartlessons.module.home.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.core.room.FavoriteManager
import com.example.quickstartlessons.databinding.FragmentHomeMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.home.ui.viewModel.HomeMainTabViewModel
import com.example.quickstartlessons.module.home.ui.adapter.CategoriesRecyclerViewAdapter
import com.example.quickstartlessons.module.home.ui.adapter.ProductsRecyclerViewAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Locale

class HomeMainTabFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeMainTabBinding
    private val viewModel by viewModel<HomeMainTabViewModel>()
    private val favoriteManager: FavoriteManager by inject()

    @SuppressLint("SetTextI18n")
    private var categoriesAdapter: CategoriesRecyclerViewAdapter = CategoriesRecyclerViewAdapter { it ->
        if (it !="All Products") {
            binding.productsHeader.text = it.toLowerCase(Locale.ROOT).replaceFirstChar {
                it.titlecase(Locale.getDefault())
            }
            viewModel.getProductsByCategory(true, categoryName = it)
        } else  {
            viewModel.getProducts(true)
            binding.productsHeader.text = "All Products"
        }
    }

    private var adapter: ProductsRecyclerViewAdapter = ProductsRecyclerViewAdapter(onItemClick = {
        findNavController().navigate(HomeMainTabFragmentDirections.actionGlobalDescriptionFragment(it.id))
    }, updateFavorites = { isFavorite, product ->
        if (isFavorite) favoriteManager.insertProduct(product) else favoriteManager.deleteProduct(product)
    })

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
        favoriteManager.getAllProducts().observe(viewLifecycleOwner){
            adapter.updateFavorites(it.map {productEntity ->
                productEntity.id
            })
        }
        viewModel.productsByCategoryErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", it)
        }
        viewModel.categoriesLiveData.observe(viewLifecycleOwner) {
            val items: MutableList<String> = mutableListOf()
            items.add("All Products")
            if (it != null) items.addAll(it)
            categoriesAdapter.updateData(items)
        }
        viewModel.categoriesErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", it)
        }
    }
}
