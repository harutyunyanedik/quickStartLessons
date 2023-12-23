package com.example.quickstartlessons.tablayout
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.quickstartlessons.databinding.FragmentFirstBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentFirst : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter:AdapterProductImage
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupRecyclerView()
        (parentFragment as BaseFragmentView).setupListener(1)
    }

    private fun setupRecyclerView(){
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=GridLayoutManager(requireContext(),2)

    }

    @SuppressLint("SetTextI18n")
    private fun setupObservers() {
        (parentFragment as BaseFragmentView).viewModel.productLiveData.observe(viewLifecycleOwner) {
            binding.productId.text = "Id :" + it?.id.toString()
            binding.title.text = "Title:" + it?.title
            binding.brand.text = "Brand:" + it?.brand
            binding.category.text = "Category:" + it?.category
            binding.description.text = "Description:" + it?.description
            binding.price.text = "Price:" + it?.price.toString()
            binding.discountPercentage.text = "DiscountPercentage:" + it?.discountPercentage.toString()
            binding.rating.text = "Rating:" + it?.rating.toString()
            binding.stock.text = "Stock:" + it?.stock.toString()
            Glide.with(requireContext()).load(it?.thumbnail).into(binding.thumbnail)
            adapter.updateData(it?.image)
        }
    }

    companion object {
        fun newInstance() = FragmentFirst()

    }
}