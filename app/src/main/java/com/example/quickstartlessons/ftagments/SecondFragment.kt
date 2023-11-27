package com.example.quickstartlessons.ftagments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backClick.setOnClickListener {
            (requireActivity() as? MainActivity)?.replaceFragments(FirstFragment.newInstance())
        }
        Glide.with(this).load("https://news.am/img/news/79/41/14/220x220.jpg").into(binding.imageSecondFragment)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
}