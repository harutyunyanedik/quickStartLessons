package com.example.quickstartlessons.android.fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.quickstartlessons.android.base.BaseFragment
import com.example.quickstartlessons.databinding.FragmentSecondPageBinding

class FragmentSecondPage : BaseFragment() {
    private lateinit var binding: FragmentSecondPageBinding
    private var url: String? = null
    private var text: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        url = arguments?.getString(PARAM1)
        text = arguments?.getString(PARAM2)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.arrowLeft.setOnClickListener {
            goBack()
        }
        Glide.with(this).load(url).into(binding.fragmentImage)
        binding.textImageView.text = text
        binding.checkboxShare.setOnClickListener {
            shareItem(text.toString(), url.toString())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(imageUrl: String, description: String) = FragmentSecondPage().apply {
            arguments = Bundle().apply {
                putString(PARAM1, imageUrl)
                putString(PARAM2, description)
            }
        }

        const val PARAM1 = "param1"
        const val PARAM2 = "param2"
    }
}