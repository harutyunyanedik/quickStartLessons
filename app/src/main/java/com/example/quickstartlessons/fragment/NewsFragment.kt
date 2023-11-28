package com.example.quickstartlessons.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.MAIN
import com.example.quickstartlessons.android.adapters.NewsAdapter
import com.example.quickstartlessons.android.adapters.TopNewsAdapter
import com.example.quickstartlessons.android.base.BaseFragment
import com.example.quickstartlessons.android.models.NewsModel
import com.example.quickstartlessons.android.models.TopModel
import com.example.quickstartlessons.databinding.FragmentGeneralBinding


class NewsFragment : BaseFragment() {
    private lateinit var binding: FragmentGeneralBinding
    val image="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnWdFQDu2akH8YestwlhyQJNKgKY0C9jLshNe8QF1ZkOS2MrHq0XmFP_RgamyJDarj8ws&usqp=CAU"
    private var adapterOne: NewsAdapter = NewsAdapter()
    private var adapter: TopNewsAdapter = TopNewsAdapter {
        replaceFragment(DescriptionFragment.newInstance())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentGeneralBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.newsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.newsRecyclerView.adapter = adapterOne
        adapterOne.updateData(createNews())

        binding.topNewsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.topNewsRecyclerView.adapter = adapter
        adapter.updateData(createTopNews())
    }


    private fun createNews(): List<NewsModel> {
        val itemOne = mutableListOf<NewsModel>()
        for (i in 0..11) {
            itemOne.add(NewsModel("News", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.escapeauthority.com%2Fcategory%2Freviews%2Ffeed%2Fno-reserve-15k-mile-2003-mercedes-benz-e320-sedan-pp-jlVvYEsW&psig=AOvVaw2g5vkEUNi5MzBSQmHz97yq&ust=1701253823259000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCODF8MzI5oIDFQAAAAAdAAAAABAE"))
        }
        return itemOne
    }

    private fun createTopNews(): List<TopModel> {
        val item = mutableListOf<TopModel>()
        for (i in 0..11) {
            item.add(TopModel("Mercedes-Benz traces its origins to Karl Benz's first internal combustion engine in a car ", image))
        }
        return item
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewsFragment()

    }


}