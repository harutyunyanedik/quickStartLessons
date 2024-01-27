package com.example.quickstartlessons.module.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.FragmentProductDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailsFragment : Fragment() {

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
        binding.rvImages.adapter = adapter
        binding.rvImages.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }

    private fun observeLiveData(){
        viewModel.productLiveData.observe(viewLifecycleOwner) {
            adapter.updateData(it?.images)
            with(binding) {
                tvTitleDetails.text = it?.title
                tvDescription.text = it?.description
                tvPriceDetails.text = "${it?.price.toString()} $"
                tvRating.text = it?.rating.toString()
            }
        }
    }

}