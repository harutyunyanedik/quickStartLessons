package com.example.quickstartlessons.module.details

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
    private val adapter = ImagesAdapter()
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
        viewModel.getProductById(id=args.id)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        setupViews()
    }

    private fun setupViews() {
        binding.imagesRecyclerView.adapter = adapter
        binding.imagesRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }

    private fun observeLiveData(){
        viewModel.productLiveData.observe(viewLifecycleOwner) {
            adapter.updateData(it?.images)
            with(binding) {
                titleTextView.text = it?.title
                descriptionTextView.text = it?.description
                priceTextView.text = "${it?.price.toString()} $"
                ratingTextView.text = it?.rating.toString()
            }
        }
        viewModel.productErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error", it ?: "Unknown error")
        }
    }

}