package com.example.quickstartlessons.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.QuickStartApplication
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentBaseBinding

class BaseFragment : Fragment() {

  private lateinit var binding:FragmentBaseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    private fun setupListenerInternetConnection(){
        QuickStartApplication.networkStateLiveData.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(requireContext(), "Connected", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Not connected", Toast.LENGTH_SHORT).show()
            }
        }
    }




}