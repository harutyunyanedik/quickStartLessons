package com.example.quickstartlessons.module.description

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentDescriptionBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.description.adapter.DescriptionsImagesRecyclerViewAdapter
import com.example.quickstartlessons.module.description.viewModel.DescriptionViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class DescriptionFragment : BaseFragment() {

    private lateinit var binding: FragmentDescriptionBinding
    private val viewModel by viewModel<DescriptionViewModel>()
    private val args: DescriptionFragmentArgs by navArgs()
    private var adapter: DescriptionsImagesRecyclerViewAdapter = DescriptionsImagesRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = args.idDescription.toInt()
        viewModel.getProduct(true, id = id)
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
    }

    private fun setupViews() {
        binding.imagesList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.imagesList.adapter = adapter
    }


    @SuppressLint("SetTextI18n")
    private fun observeLiveData() {
        viewModel.productLiveData.observe(viewLifecycleOwner) {

            binding.idDescription.text = "ID: " + it?.id.toString()
            binding.description.text = getString(R.string.description) + " ${it?.description}"
            binding.descriptionPrice.text = getString(R.string.price) + " ${it?.price} $"
            binding.descriptionTitle.text = getString(R.string.title) + " ${it?.title}"
            binding.brand.text = getString(R.string.brand) + " ${it?.brand}"
            binding.category.text = getString(R.string.category) + " ${it?.category}"
            binding.discountPercentage.text = getString(R.string.discountPercentage) + " ${it?.discountPercentage} %"
            binding.rating.text = getString(R.string.rating) + " ${it?.rating}"
            adapter.updateData(it?.images)
        }
        viewModel.productErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", it)
        }
    }

}