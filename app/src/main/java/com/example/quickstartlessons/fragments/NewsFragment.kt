package com.example.quickstartlessons.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View{
        binding = FragmentNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnadd.setOnClicklistener{
            (requireActivity() as MainActivity).addFragment(DescriptionFragment))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewsFragment()

    }
}