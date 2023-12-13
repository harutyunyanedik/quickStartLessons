package com.example.quickstartlessons.homwork.model

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.databinding.FragmentPhotoBinding
import com.example.quickstartlessons.homwork.fragment.FragmentPhoto

class AdapterPhoto:RecyclerView.Adapter<AdapterPhoto.PhotoViewHolder>() {
    inner class PhotoViewHolder(private val binding:FragmentPhotoBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}