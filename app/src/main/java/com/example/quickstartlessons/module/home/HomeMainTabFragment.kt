package com.example.quickstartlessons.module.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickstartlessons.databinding.ItemHomeMainTabBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.product.ProductAdapter
import com.example.quickstartlessons.module.product.ProductViewModel


class HomeMainTabFragment : BaseFragment() {
  private lateinit var binding:ItemHomeMainTabBinding
  private lateinit var  adapter:ProductAdapter
  private val viewModel:ProductViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ItemHomeMainTabBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()

    }
    private fun setupView(){
        viewModel.getProduct()
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=GridLayoutManager(requireContext(),2)
        viewModel.productLiveData.observe(viewLifecycleOwner){
            adapter.updateData(it)
        }

    }
}