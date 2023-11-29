package com.example.quickstartlessons.android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.adapter.AdapterFirstImageView
import com.example.quickstartlessons.android.adapter.AdapterNewsImage
import com.example.quickstartlessons.android.base.BaseFragment
import com.example.quickstartlessons.android.model.RvModelImage
import com.example.quickstartlessons.databinding.FragmentFirsPageNewsBinding
import com.example.quickstartlessons.databinding.FragmentRootBinding
import com.example.quickstartlessons.android.model.RvNewsModel

class RootFragment : BaseFragment(){
    private lateinit var binding: FragmentRootBinding
    private val adapterImage = AdapterFirstImageView()
    private val adapterNews = AdapterNewsImage {
        replaceFragment(FragmentSecondPage.newInstance())
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRootBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      setupRecyclerView()
    }

    fun setupRecyclerView() {
        binding.recyclerViewNews.adapter = adapterNews
        binding.recyclerViewNews.layoutManager=LinearLayoutManager(requireContext())
        adapterNews.updateData(createNewsList())
        binding.recyclerViewImage.adapter=adapterImage
        binding.recyclerViewImage.layoutManager=LinearLayoutManager(requireContext())
        adapterImage.updateData(createImageList())
    }
    private fun createNewsList(): List<RvNewsModel> {
        val list = mutableListOf<RvNewsModel>()
        for (i in 0..10) {
            list.add(RvNewsModel("https://ru.wikipedia.org/wiki/JPEG#/media/%D0%A4%D0%B0%D0%B9%D0%BB:JPEG_example_down.jpg", "hhhhhhhhh"))

        }
        return list
    }
    private fun createImageList():List<RvModelImage>{
        val list= mutableListOf<RvModelImage>()
        for (i in 0..10){
            list.add(RvModelImage("https://ru.wikipedia.org/wiki/JPEG#/media/%D0%A4%D0%B0%D0%B9%D0%BB:JPEG_example_down.jpg"))
        }
        return list
    }

    companion object {
        @JvmStatic
        fun newInstance() = RootFragment()


    }
}