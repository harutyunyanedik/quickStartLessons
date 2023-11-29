package com.example.quickstartlessons.android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.databinding.FragmentSecondPageBinding
class FragmentSecondPage : Fragment() {
    private lateinit var binding:FragmentSecondPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentSecondPageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.arrowLeft.setOnClickListener{
            (requireActivity() as? MainActivity)?.addFragment(RootFragment.newInstance())
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = FragmentSecondPage()

            }

}