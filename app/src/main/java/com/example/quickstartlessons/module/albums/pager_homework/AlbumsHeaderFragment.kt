package com.example.quickstartlessons.module.albums.pager_homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quickstartlessons.databinding.FragmentAlbumsHeaderBinding
import com.google.android.material.tabs.TabLayoutMediator

class AlbumsHeaderFragment : Fragment() {
    private lateinit var binding: FragmentAlbumsHeaderBinding
    private lateinit var adapter: FragmentAlbumAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumsHeaderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter= FragmentAlbumAdapter(childFragmentManager,viewLifecycleOwner.lifecycle)
        binding.pager.adapter = adapter
        val fragments = mutableListOf(FirstFragment.newInstance(), SecondFragment.newInstance())
        adapter.updateData(fragments)
        binding.pager.apply {
            adapter = this@AlbumsHeaderFragment.adapter
            offscreenPageLimit = fragments.size
            isUserInputEnabled = false
        }

        TabLayoutMediator(binding.tabLayout,binding.pager){tab,position ->
            when (fragments[position]) {
                is FirstFragment -> tab.text = "Email"
                is SecondFragment -> tab.text = "Sms"
            }
        }.attach()
    }
    companion object {
        fun newInstance() = AlbumsHeaderFragment()
    }
}