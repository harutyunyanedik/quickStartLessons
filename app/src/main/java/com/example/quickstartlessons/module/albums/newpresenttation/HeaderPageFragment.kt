package com.example.quickstartlessons.module.albums.newpresenttation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.FragmentHeaderPageBinding

class HeaderPageFragment(private val onPlusButtonClicked:()-> Unit) : Fragment() {
    private lateinit var binding: FragmentHeaderPageBinding
    private val adapter: ItemsRecyclerViewAdapter = ItemsRecyclerViewAdapter()
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeaderPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupValues()
        binding.plusButton.setOnClickListener {
            onPlusButtonClicked.invoke()
        }
    }

    private fun setupValues() {
        binding.recyclerView.adapter = this.adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
       viewModel.listLiveData.observe(viewLifecycleOwner){
           adapter.updateData(it)
       }
    }


    companion object {


        @JvmStatic
        fun newInstance(onPlusButtonClicked:()-> Unit) = HeaderPageFragment(onPlusButtonClicked)
    }

}