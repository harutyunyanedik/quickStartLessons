package com.example.quickstartlessons.android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentEqualButtonBinding

class FragmentEqualButton : Fragment() {
    private lateinit var binding: FragmentEqualButtonBinding
    private var number: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        number=arguments?.getString(NUMBER_ONE)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEqualButtonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       number= 1.toString()

    }

    companion object {
        @JvmStatic
        fun newInstance(number: Int) = FragmentEqualButton().apply {
            arguments = Bundle().apply {
                putInt(NUMBER_ONE, number)
            }

        }

        private const val NUMBER_ONE = "number_one"
    }
}