package com.example.quickstartlessons.module.home.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.FragmentHomeMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.base.utils.QsConstants
import com.example.quickstartlessons.module.home.ui.adapter.CategoriesAdapter
import com.example.quickstartlessons.module.home.ui.adapter.ProductAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeMainTabFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeMainTabBinding
    private val adapter = ProductAdapter()
    private val adapterCategories = CategoriesAdapter { category ->

        if (category == QsConstants.ALL_PRODUCTS) { // todo delete constant use resurce
            viewModel.getProduct()
        } else {
            viewModel.geProductByCategory(true, category)
        }
        binding.toolBarName.text = category.replaceFirstChar {
            it.uppercase()
        }

    }
    private val viewModel by viewModel<HomeMainTabViewModel>()


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

    @SuppressLint("SuspiciousIndentation")
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
            val list = mutableListOf<String>()
            list.add(QsConstants.ALL_PRODUCTS)
            if (it != null) {
                list.addAll(it)
            }
            adapterCategories.updateData(list)

        }
        viewModel.categoryErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error data", it.toString())
        }

    }
}
