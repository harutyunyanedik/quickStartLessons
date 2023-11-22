package com.example.quickstartlessons.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.adapters.CitiesAdapter
import com.example.quickstartlessons.databinding.FragmentRecyclerBinding
import com.example.quickstartlessons.models.RecyclerViewModel
import kotlin.random.Random


class RecyclerFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerBinding
    private val adapter = CitiesAdapter()
    private val cities = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createCities()
        setAdapter()
    }

    private fun setAdapter() {
        binding.rvMultipleViewHolder.adapter = adapter
        binding.rvMultipleViewHolder.layoutManager = LinearLayoutManager(context)
        adapter.updateAdapter(createModels())
    }

    private fun createModels(): List<RecyclerViewModel> {
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

    private fun createCities() {
        cities.add("Yerevan")
        cities.add("London")
        cities.add("Paris")
        cities.add("Los Angeles")
        cities.add("New York")
        cities.add("Glendale")
        cities.add("Berlin")
    }

    companion object {
        @JvmStatic
        fun newInstance() = RecyclerFragment()

    }
}