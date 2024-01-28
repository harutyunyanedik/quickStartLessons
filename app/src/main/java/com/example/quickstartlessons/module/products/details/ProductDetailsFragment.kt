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
    private var adapter = ProductImagesAdapter()
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
        binding.imagesRecyclerView.adapter = adapter
        binding.imagesRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }

    @SuppressLint("SetTextI18n")
    private fun observeLiveData() {
        viewModel.productDetailsLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.updateData(it.images)
            }
            binding.titleTextView.text = it?.title
            binding.descriptionTextView.text = it?.description
            binding.priceTextView.text = "${it?.price} $"
            if (it != null) {
                binding.favoriteCheckbox.isChecked = it.isFavorite
                adapter.updateData(it.images)
            }
        }
        viewModel.productDetailsErrorLiveData.observe(viewLifecycleOwner) {
           showErrorMessageDialog("Error Dialog", it ?: "Unknown error")
        }
    }
}