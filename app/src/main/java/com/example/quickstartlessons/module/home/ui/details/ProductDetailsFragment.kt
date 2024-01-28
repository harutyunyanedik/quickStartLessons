package com.example.quickstartlessons.module.home.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.FragmentProductBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.home.ui.adapter.ProductImageAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailsFragment : BaseFragment() {
    private lateinit var binding: FragmentProductBinding
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

        binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupObserve()
        binding.toolBar.setOnClickListener{
            findNavController().navigateUp()
        }
    }

    private fun setupView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    @SuppressLint("SetTextI18n")
    private fun setupObserve() {
        viewModel.productByIdLiveData.observe(viewLifecycleOwner) {
            binding.title.text = it?.title
            binding.rating.text = "Rating:${it?.rating}"
            binding.discountPercentage.text = "DiscountPercentage :${it?.discountPercentage}%"
            binding.stock.text = "Stock :${it?.stock}"
            binding.description.text = it?.description
            binding.price.text = "${it?.price} $"
            binding.favoriteProduct.isChecked = it?.favorite == true
            adapter.updateData(it?.image)
        }
        viewModel.productByIdErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error data", it.toString())
        }

    }
}