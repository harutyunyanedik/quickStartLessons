package com.example.quickstartlessons.module.albums.pager_homework

import androidx.fragment.app.Fragment
import com.example.quickstartlessons.MainActivity

abstract class BaseFragment : Fragment() {

    private fun addLoader(isShoLoader: Boolean) {
        MainActivity.loaderLiveData.postValue(true)
    }

    private fun removeLoader(isShoLoader: Boolean) {
        MainActivity.loaderLiveData.postValue(false)
    }

}