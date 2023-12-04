package com.example.quickstartlessons.android.fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.adapter.AdapterNewsImage
import com.example.quickstartlessons.android.base.BaseFragment
import com.example.quickstartlessons.android.extension.mainActivity
import com.example.quickstartlessons.databinding.FragmentSecondPageBinding
class FragmentSecondPage : BaseFragment() {
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

        val image=arguments?.getString(RootFragment.PARAMS_ONE)
        Glide.with(this).load(image).into(binding.fragmentImage)
        val text =arguments?.getString(RootFragment.PARAMS_TWO)
        binding.textImageView.text=text


        binding.arrowLeft.setOnClickListener{
         goBack()
        }

       // binding.checkboxShare.setOnCheckedChangeListener {

       // }
    }
    companion object {
        @JvmStatic
        fun newInstance() = FragmentSecondPage()

            }

}