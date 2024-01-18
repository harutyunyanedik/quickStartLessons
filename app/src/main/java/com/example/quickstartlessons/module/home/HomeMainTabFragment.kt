package com.example.quickstartlessons.module.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.FragmentHomeMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.data.ProductMapper
import java.util.Locale

class HomeMainTabFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeMainTabBinding
    private val productsAdapter = ProductsAdapter()
    private val categoriesAdapter = CategoriesAdapter()
    private val viewModel: ProductsViewModel by viewModels()
    private val mapper = ProductMapper()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeMainTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()

    }

    private fun setupViews() {
        binding.rvProducts.adapter = productsAdapter
        binding.rvProducts.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvCategories.adapter = categoriesAdapter
        binding.rvCategories.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        viewModel.getCategories()
        viewModel.getProducts()
        viewModel.categoryLiveData.observe(viewLifecycleOwner) {
            categoriesAdapter.updateData(mapper.listStringToListCategory(it))
        }

        viewModel.productLiveData.observe(viewLifecycleOwner) {
            productsAdapter.updateData(mapper.listProductsDtoToListProducts(it))
        }

        categoriesAdapter.onCategoryClick = {
            viewModel.getProductsByCategory(category = it)
            binding.tvProducts.text = it.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

        }


        viewModel.productErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error", it!!)

        }
    }

}