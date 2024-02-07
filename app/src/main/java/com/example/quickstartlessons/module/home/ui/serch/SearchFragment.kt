package com.example.quickstartlessons.module.home.ui.serch

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.core.room.FavoriteManager
import com.example.quickstartlessons.databinding.FragmentSearchBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.home.ui.HomeMainTabFragmentDirections
import com.example.quickstartlessons.module.home.ui.adapter.ProductAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val favoriteManager: FavoriteManager by inject()
    private val adapter = ProductAdapter(onItemClick = {
        findNavController().navigate(HomeMainTabFragmentDirections.actionGlobalProductDetailsFragment(it.id.toString()))
    }, updateFavorite = { isFavorite, product ->
        if (isFavorite) favoriteManager.insertProduct(product) else favoriteManager.deleteProductById(product)
    })
    private val viewModel by viewModel<SearchViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
        setupView()
        observerSearch()
    }


    private fun setupView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun setupListener() {
        binding.toolBar.setOnClickListener {
           findNavController().navigateUp()
        }
        binding.searchEditText.doAfterTextChanged { it ->
            if (it != null && it.length > 2) {
                viewModel.search(true, it.toString())
           } else {
                viewModel.clearValue()
            }
        }
    }

    private fun observerSearch() {
        viewModel.searchProductLiveData.observe(viewLifecycleOwner) { it ->
            adapter.updateData(it)
            binding.textView.isVisible = it.isNullOrEmpty()
        }
        viewModel.searchProductErrorLiveData.observe(viewLifecycleOwner) {
            BaseFragment.showErrorMessageDialog(getString(R.string.error_data), it.toString())
        }
    }
}