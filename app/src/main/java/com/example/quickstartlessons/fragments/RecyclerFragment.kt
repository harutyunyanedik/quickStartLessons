package com.example.quickstartlessons.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.adapters.TitleAdapter
import com.example.quickstartlessons.databinding.FragmentRecyclerBinding
import com.example.quickstartlessons.models.RecyclerModel


class RecyclerFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerBinding
    private val adapter = TitleAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerBinding.inflate(inflater, container, false)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.rvTitle.adapter = adapter
        binding.rvTitle.layoutManager = LinearLayoutManager(requireContext())
        adapter.updateAdapter(createList())
        adapter.onItemClick = {delete, item ->
            if (delete){
                adapter.deleteItem(item)
            }
        }

    }

    private fun createList(): List<RecyclerModel>{
        val list = mutableListOf<RecyclerModel>()
        for (i in 1..100){
            list.add(RecyclerModel("Title $i"))
        }
        return list
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            RecyclerFragment()
    }
}