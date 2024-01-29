package com.example.quickstartlessons.module.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.R
import com.example.quickstartlessons.core.room.FavoriteManager
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import org.koin.android.ext.android.inject

class FavoriteMainTabFragment : BaseFragment() {

    private val favoriteManager by inject<FavoriteManager>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_main_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteManager.getAllProducts().observe(viewLifecycleOwner) {
            println(it)
        }
    }
}