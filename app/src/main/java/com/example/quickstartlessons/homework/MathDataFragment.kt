package com.example.quickstartlessons.homework

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentMathDataBinding
import com.example.quickstartlessons.homework.LivaData.MathData
import com.example.quickstartlessons.homework.LivaData.MathLiveData

class MathDataFragment : Fragment() {
    private lateinit var binding: FragmentMathDataBinding
    private lateinit var liveData: MathLiveData

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMathDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        liveData.observeOnc(viewLifecycleOwner) { it ->
            binding.mathData.text = it

        }
    }
    private lateinit var recordObserver: Observer<String>

}