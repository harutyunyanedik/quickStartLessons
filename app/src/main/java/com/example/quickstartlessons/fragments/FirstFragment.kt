package com.example.quickstartlessons.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.adapter.MultiViewHolderAdapter
import com.example.quickstartlessons.databinding.FragmentFirstBinding
import com.example.quickstartlessons.model.RecyclerViewModel
import kotlin.random.Random

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private var adapter = MultiViewHolderAdapter()
    private val cities = mutableListOf<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listCites()
        setAdapter()
    }


    private fun setAdapter() {
        binding.fragment.adapter = adapter
        binding.fragment.layoutManager = LinearLayoutManager(context)
        adapter.updateData(createDemoList())
    }

    private fun createDemoList(): List<RecyclerViewModel> {
        val list = mutableListOf<RecyclerViewModel>()
        for (i in cities) {
            list.add(RecyclerViewModel(i))
            val to = Random.nextInt(0, 3)
            for (j in 0..to) {
                list.add(RecyclerViewModel(title = "Droidcon"))
                list.add(RecyclerViewModel(description = "Droidcon in $i"))
            }
        }
        return list
    }

    private fun listCites() {
        cities.add("Yerevan")
        cities.add("Berlin")
        cities.add("London")
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()

    }
}