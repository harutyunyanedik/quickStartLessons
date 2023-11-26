package com.example.quickstartlessons.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.adapters.NewsAdapter
import com.example.quickstartlessons.adapters.NewsTypeAdapter
import com.example.quickstartlessons.databinding.FragmentMainBinding
import com.example.quickstartlessons.models.Colors
import com.example.quickstartlessons.models.NewsModel
import com.example.quickstartlessons.models.NewsType
import com.example.quickstartlessons.models.NewsTypeModel


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val adapterNews = NewsAdapter ({
        requireActivity().supportFragmentManager.beginTransaction().add(
            R.id.container, DescriptionFragment.newInstance(
                it.title,
                it.data,
                it.imageUrl,
                it.description
            ), DescriptionFragment::class.java.simpleName
        )
            .addToBackStack(null)
            .commit()
    }, {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TITLE, it.title)
        intent.putExtra(Intent.EXTRA_TEXT, it.description)
        val shareIntent = Intent.createChooser(intent, null)
        startActivity(shareIntent)
    })
    private val adapterNewsType = NewsTypeAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapters()
    }

    private fun setupAdapters() {
        with(binding) {
            recyclerViewNews.adapter = adapterNews
            recyclerViewNews.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapterNews.updateAdapter(setupNewsList())

            recyclerViewNewsTypes.adapter = adapterNewsType
            recyclerViewNewsTypes.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapterNewsType.updateAdapter(setupNewsTypeList())

        }
    }

    private fun setupNewsList(): List<NewsModel> {
        val list = mutableListOf<NewsModel>()
        for (i in 0..10) {
            list.add(
                NewsModel(
                    "https://get.wallhere.com/photo/city-night-building-reflection-1539053.jpg",
                    "The Latest Market Thinking From The World's Finance Experts",
                    "23 Nov 2023",
                    "The Latest Market Thinking From The World's Finance Experts"
                )
            )
            list.add(
                NewsModel(
                    "https://www.dianomi.com/img/a/sav2/222444/6/365x245.jpg",
                    "Discover the latest trends and ideas for retirement planning",
                    "20 Nov 2023",
                    "Discover the latest trends and ideas for retirement planning"
                )
            )
        }
        return list
    }

    private fun setupNewsTypeList(): List<NewsTypeModel> {
        val list = mutableListOf<NewsTypeModel>()
        list.add(NewsTypeModel("News", NewsType.NEWS, Colors.BLUE))
        list.add(NewsTypeModel("Crypto", NewsType.CRYPTO, Colors.ROSE))
        list.add(NewsTypeModel("Sport", NewsType.SPORT, Colors.RED))
        list.add(NewsTypeModel("Style", NewsType.STYLE, Colors.ORANGE))
        list.add(NewsTypeModel("Medicine", NewsType.MEDICINE, Colors.GREEN))
        list.add(NewsTypeModel("Tech", NewsType.TECH, Colors.DARK_BLUE))
        return list
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment()

    }
}