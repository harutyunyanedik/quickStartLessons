package com.example.quickstartlessons.module.home.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.FragmentProductDetailsBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.home.ui.adapter.ProductImageAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailsFragment : BaseFragment() {
    private lateinit var binding: FragmentProductDetailsBinding
    private val adapter = ProductImageAdapter()
    private val viewModel by viewModel<ProductDetailsViewModel>()
    private val args: ProductDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getProductById(true, args.productId.toInt())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        observeLiveData()
        setupListeners()
    }

    private fun setupListeners() {
        binding.toolBar.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setupView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    @SuppressLint("SetTextI18n")
    private fun observeLiveData() {
        viewModel.productByIdLiveData.observe(viewLifecycleOwner) {
            binding.titleTextView.text = it?.title
            binding.ratingTextView.text = "Rating:${it?.rating}"
            binding.discountPercentageTextView.text = "DiscountPercentage :${it?.discountPercentage}%"
            binding.stockTextView.text = "Stock :${it?.stock}"
            binding.descriptionTextView.text = it?.description
            binding.priceTextView.text = "${it?.price} $"
            binding.favoriteProductCheckbox.isChecked = it?.favorite == true
            adapter.updateData(it?.image)
        }
        viewModel.productByIdErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error data", it.toString())
        }
    }
}