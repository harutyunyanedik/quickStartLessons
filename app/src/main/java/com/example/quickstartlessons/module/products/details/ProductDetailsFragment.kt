package com.example.quickstartlessons.module.products.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentProductDetailsBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.home.ui.viewmodel.HomeMainTabViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding
    private lateinit var adapter: ProductDetailsAdapter
    private val viewModel by viewModel<HomeMainTabViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getProductsDetail()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        observeLiveData()
    }

   private fun setUpViews(){
        binding.rvProductDetail.adapter = adapter
        binding.rvProductDetail.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

    }

    private fun observeLiveData(){
        viewModel.productDetailsLiveData.observe(viewLifecycleOwner) {
           adapter.updateDataDetails(it)
        }
        viewModel.productDetailsErrorLiveData.observe(viewLifecycleOwner) {
            BaseFragment.showErrorMessageDialog("Error Dialog", it ?: "Unknown error")
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = ProductDetailsFragment()
    }
}