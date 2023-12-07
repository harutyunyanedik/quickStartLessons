package com.example.quickstartlessons.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quickstartlessons.R
import com.example.quickstartlessons.activities.MainActivity
import com.example.quickstartlessons.data.Count
import com.example.quickstartlessons.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAdd.setOnClickListener {
            Count.addCount()
            (requireActivity() as MainActivity).replaceFragment(CounterFragment.newInstance(), R.id.container2)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AddFragment()
    }
}