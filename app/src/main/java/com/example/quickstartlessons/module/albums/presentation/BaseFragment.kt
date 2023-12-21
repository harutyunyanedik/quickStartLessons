package com.example.quickstartlessons.module.albums.presentation

import androidx.fragment.app.Fragment
import com.example.quickstartlessons.MainActivity

open class BaseFragment : Fragment() {

    companion object {
        open fun addLoader() {
            MainActivity.isShow.postValue(true)
        }

        open fun removeLoader() {
            MainActivity.isShow.postValue(false)
        }
    }


}