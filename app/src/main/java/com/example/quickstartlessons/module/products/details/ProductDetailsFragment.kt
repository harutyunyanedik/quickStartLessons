package com.example.quickstartlessons.module.products.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.FragmentProductDetailsBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentProductDetailsBinding
    private var adapter = ProductDetailsAdapter()
    private val viewModel by viewModel<ProductDetailsViewModel>()
    private val args by navArgs<ProductDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getProductsDetail(id = args.id)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        setUpViews()
    }

    private fun setUpViews() {
        binding.rvProductDetail.adapter = adapter
        binding.rvProductDetail.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

    }

    @SuppressLint("SetTextI18n")
    private fun observeLiveData() {
        viewModel.productDetailsLiveData.observe(viewLifecycleOwner) {
            adapter.updateDataDetails(it?.images)
            binding.productTitle.text = it?.title
            binding.productDetailedDescription.text = it?.description
            binding.productPrice.text = "${it?.price} $"
            if (it != null) {
                binding.checkboxFavorite.isChecked = it.isFavorite
                adapter.updateDataDetails(it.images)
            }
        }
        viewModel.productDetailsErrorLiveData.observe(viewLifecycleOwner) {
           showErrorMessageDialog("Error Dialog", it ?: "Unknown error")
        }
    }
}