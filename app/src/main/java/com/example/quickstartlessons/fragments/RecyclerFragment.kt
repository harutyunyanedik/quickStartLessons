package com.example.quickstartlessons.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.adapters.ItemAdapter
import com.example.quickstartlessons.databinding.FragmentRecyclerBinding
import com.example.quickstartlessons.models.ItemModel


class RecyclerFragment : BaseFragment() {
    private lateinit var binding: FragmentRecyclerBinding
    private val adapter = ItemAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.recyclerViewTitle.adapter = adapter
        binding.recyclerViewTitle.layoutManager = LinearLayoutManager(requireContext())
        adapter.updateAdapter(createList())

    }

    private fun createList(): List<ItemModel> {
        val list = mutableListOf<ItemModel>()
        for (i in 0..50) {
            list.add(ItemModel("Item $i"))

        }
        return list
    }

    companion object {
        @JvmStatic
        fun newInstance() = RecyclerFragment()
    }
}