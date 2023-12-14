package com.example.quickstartlessons.module.albums.albumDatails

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.adapters.ImagesRecyclerViewAdapter
import com.example.quickstartlessons.adapters.Model
import com.example.quickstartlessons.databinding.FragmentAlbumDatailsBinding

class AlbumDatailsFragment : Fragment() {

    private lateinit var binding: FragmentAlbumDatailsBinding
    private val args:AlbumDatailsFragmentArgs by navArgs()
    private var item: MutableList<Model> = mutableListOf()
    private var adapter: ImagesRecyclerViewAdapter = ImagesRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumDatailsBinding.inflate(inflater, container, false)
        return binding.root
       args.albumId
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupImages()
    }

    private fun setupImages() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        adapter.updateData(createImages())
    }

    private fun createImages(): List<Model> {
        for (i in 0..2) {
            //item.add(Model("accusamus beatae ad facilis cum similique qui sunt","https://via.placeholder.com/150/92c952"))
        }
        return item
    }
}