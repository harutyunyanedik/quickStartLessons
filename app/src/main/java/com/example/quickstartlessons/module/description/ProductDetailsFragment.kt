package com.example.quickstartlessons.module.description

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentDescriptionBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.description.adapter.ProductImagesAdapter
import com.example.quickstartlessons.module.description.viewModel.ProductDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentDescriptionBinding
    private val viewModel by viewModel<ProductDetailsViewModel>()
    private val args: ProductDetailsFragmentArgs by navArgs()
    private var adapter: ProductImagesAdapter = ProductImagesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = args.id
        viewModel.getProductById(true, id = id)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeLiveData()

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setupViews() {
        binding.imagesRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.imagesRecyclerView.adapter = adapter
    }

    @SuppressLint("SetTextI18n")
    private fun observeLiveData() {
        viewModel.productLiveData.observe(viewLifecycleOwner) {

            binding.descriptionTextView.text = getString(R.string.description) + " ${it?.description}"
            binding.priceTextView.text = getString(R.string.price) + " ${it?.price} $"
            binding.titleTextView.text = getString(R.string.title) + " ${it?.title}"
            binding.toolbarText.text = it?.title
            binding.brandTextView.text = getString(R.string.brand) + " ${it?.brand}"
            binding.categoryTextView.text = getString(R.string.category) + " ${it?.category}"
            binding.discountPercentageTextView.text = getString(R.string.discountPercentage) + " ${it?.discountPercentage} %"
            binding.ratingTextView.text = getString(R.string.rating) + " ${it?.rating}"
            adapter.updateData(it?.images)
        }
        viewModel.productErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", it)
        }
    }

}