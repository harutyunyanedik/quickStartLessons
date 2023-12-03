package com.example.quickstartlessons.android.ftagments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.android.adapters.NewsAdapterAdapter
import com.example.quickstartlessons.android.adapters.TopNewsAdapter
import com.example.quickstartlessons.android.base.BaseFragment
import com.example.quickstartlessons.android.models.Model
import com.example.quickstartlessons.android.models.ModelOne
import com.example.quickstartlessons.databinding.FragmentNewsBinding


private const val ACTIVITY_EXTRA_KEY = "https://news.am/img/news/79/41/14/220x220.jpg"

class NewsFragment : BaseFragment() {
    var param1: String? = null
    private lateinit var binding: FragmentNewsBinding
    private var adapterOne: NewsAdapterAdapter = NewsAdapterAdapter()
    private var adapter: TopNewsAdapter = TopNewsAdapter {
        sharText()
        replaceFragment(NewsDescriptionFragment.newInstance())
        NewsFragment().param1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ACTIVITY_EXTRA_KEY)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
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


    private fun createNews(): List<ModelOne> {
        val itemOne = mutableListOf<ModelOne>()
        for (i in 0..11) {
            itemOne.add(ModelOne("News", "@drawable/baseline_arrow_back_24"))
        }
        return itemOne
    }

    private fun createTopNews(): List<Model> {
        val item = mutableListOf<Model>()
        for (i in 0..11) {
            item.add(Model("Toyota-ն հետ է կանչում ավելի քան կես միլիոն ավտոմեքենա՝ անսարք արգելակների պատճառով", ACTIVITY_EXTRA_KEY))
        }
        return item
    }

    private fun sharText() {
        val sendIntent = Intent(Intent.ACTION_SEND)
        val sharBody = "Toyota-ն հետ է կանչում ավելի քան կես միլիոն ավտոմեքենա՝ անսարք արգելակների պատճառով"
        sendIntent.type = "text/plain"
        sendIntent.putExtra(Intent.EXTRA_TEXT, sharBody)
        startActivity(Intent(Intent.createChooser(sendIntent, "share")))
    }

    companion object {
        @JvmStatic
        fun newInstance() {
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ACTIVITY_EXTRA_KEY, param1)
                }
            }
        }
    }
}