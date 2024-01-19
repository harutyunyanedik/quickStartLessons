package com.example.quickstartlessons.module.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.ItemHomeMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.category.data.model.response.ui.CategoriesAdapter
import com.example.quickstartlessons.module.product.ui.ProductAdapter

class HomeMainTabFragment : BaseFragment() {
    private lateinit var binding: ItemHomeMainTabBinding
    private val adapter = ProductAdapter()
    private val adapterCategories = CategoriesAdapter()
    private val viewModel: HomeMainTabViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getProduct()
        viewModel.getCategories(true, "categories")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ItemHomeMainTabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObserve()
    }

    private fun setupViews() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerViewCategory.adapter = adapterCategories
        binding.recyclerViewCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupObserve() {
        viewModel.productLiveData.observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }
        viewModel.productErrorLiveData.observe(viewLifecycleOwner) {
             showErrorMessageDialog("Error data", it.toString())
        }
        viewModel.productLiveDataCategory.observe(viewLifecycleOwner) {
            adapterCategories.updateData(it)
        }
        viewModel.productErrorLiveDataCategory.observe(viewLifecycleOwner) {it->
            showErrorMessageDialog("Error data", it.toString()) // todo showErrorMessageDialog()
        }
    }
}