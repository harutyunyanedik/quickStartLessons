package com.example.quickstartlessons.module.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.FragmentHomeMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.home.ui.adapter.CategoriesAdapter
import com.example.quickstartlessons.module.home.ui.adapter.ProductAdapter
import java.util.Locale

class HomeMainTabFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeMainTabBinding
    private val adapter = ProductAdapter()
    private val adapterCategories = CategoriesAdapter{ category->
         viewModel.geProductByCategory(true,category)
        binding.toolBarName.text=category.replaceFirstChar {
           it.uppercase()
        }
    }
    private val viewModel: HomeMainTabViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getProduct()
        viewModel.getCategories()
    }

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
        viewModel.categoryLiveData.observe(viewLifecycleOwner) {
            adapterCategories.updateData(it)
        }
        viewModel.categoryErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error data", it.toString())
        }

    }
}