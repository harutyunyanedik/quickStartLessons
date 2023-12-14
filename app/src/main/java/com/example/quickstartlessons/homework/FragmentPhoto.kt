package com.example.quickstartlessons.homework

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.databinding.ItemPhotoFragmentBinding

@Suppress("DEPRECATION")
class FragmentPhoto : Fragment() {
    private lateinit var binding: ItemPhotoFragmentBinding
    private val adapter = AdapterPhoto {
         isOnline()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemPhotoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        binding.recyclerViewPhoto.adapter = adapter
        binding.recyclerViewPhoto.layoutManager = LinearLayoutManager(requireContext())
        adapter.updateData(createNewList())

    }
   private fun isOnline() {
        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val netInfo = cm.activeNetworkInfo
            if ( netInfo?.isConnectedOrConnecting==true){

            findNavController().navigate(FragmentPhotoDirections.actionFragmentPhotoToFragmentNavigate(""))
            }
            else {
                Toast.makeText(context, "No internet connection", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun createNewList(): List<Photo> {
        val list = mutableListOf<Photo>()
        for (i in 0..20) {
            list.add(Photo("green square", "https://via.placeholder.com/150/92c952"))
            list.add(Photo("purple square", "https://via.placeholder.com/150/771796"))
        }
        return list
    }
}