package com.example.quickstartlessons.module.favourite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.R

class FavouriteMainTabFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite_main_tab, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FavouriteMainTabFragment()
    }
}