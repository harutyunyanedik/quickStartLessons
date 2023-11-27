package com.example.quickstartlessons.ftagments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.android.FirstRecyclerAdapter
import com.example.quickstartlessons.android.Model
import com.example.quickstartlessons.android.ModelOne
import com.example.quickstartlessons.android.SecondRecyclerAdapter
import com.example.quickstartlessons.databinding.FirstFragmentBinding
import kotlin.random.Random

class FirstFragment : Fragment() {

    private lateinit var binding: FirstFragmentBinding
    private var adapterOne:FirstRecyclerAdapter = FirstRecyclerAdapter()
    private var adapter:SecondRecyclerAdapter = SecondRecyclerAdapter{
       (requireActivity() as? MainActivity)?.replaceFragments(fragment = SecondFragment.newInstance())

    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FirstFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleViewOne()
        setupRecycleView()

    }
    @SuppressLint("SuspiciousIndentation")
    private fun setupRecycleViewOne() {
        binding.firstRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.firstRecyclerView.adapter = adapterOne
        adapterOne.updateData(createListOne())
    }

    private fun createListOne(): List<ModelOne> {
        val itemOne = mutableListOf<ModelOne>()
        for (i in 0..11) {
            itemOne.add(ModelOne("News","@drawable/baseline_library_books_24"))
        }
        return itemOne
    }

    private fun setupRecycleView() {
        binding.secondRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.secondRecyclerView.adapter = adapter
        adapter.updateData(createList())
    }

    private fun createList(): List<Model> {
        val item = mutableListOf<Model>()
        for (i in 0..11) {
            item.add(Model("Toyota-ն հետ է կանչում ավելի քան կես միլիոն ավտոմեքենա՝ անսարք արգելակների պատճառով", "https://news.am/img/news/79/41/14/220x220.jpg"))
        }
        return item
    }
    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()

    }
}