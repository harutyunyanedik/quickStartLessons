package com.example.quickstartlessons.homwork.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ItemPhotoFragmentBinding
import com.example.quickstartlessons.homwork.internetconnection.NetworkConnection
import com.example.quickstartlessons.homwork.internetconnection.isNetworkAvailable

class FragmentPhoto : Fragment() {
  private lateinit var  binding:ItemPhotoFragmentBinding


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      binding= ItemPhotoFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      if(isNetworkAvailable(requireContext())){

      }

    }


  // private fun setupRecyclerView() {
  //     binding.recyclerViewPhoto.adapter = adapter
  //     binding.recyclerViewPhoto.layoutManager = LinearLayoutManager(requireContext())
  //     adapter.updateData(list)
  // }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentPhoto()

    }
}