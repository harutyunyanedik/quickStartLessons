package com.example.quickstartlessons.module

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonObserver1.setOnClickListener {
            if ((requireActivity() as MainActivity).liveData.hasActiveObservers()){
                (requireActivity() as MainActivity).liveData.removeObservers(requireActivity())
            }
            (requireActivity() as MainActivity).liveData.observe(requireActivity()){
                binding.textViewTitle1.text = it
            }

        }
    }

    companion object {
        fun newInstance() = FirstFragment()
    }


}
