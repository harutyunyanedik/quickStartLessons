package com.example.quickstartlessons.android.base

import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.quickstartlessons.android.extension.mainActivity

abstract class BaseFragment : Fragment() {
    fun addFragment(fragment: Fragment) {
        mainActivity().addFragment(fragment)
    }

    fun replaceFragment(fragment: Fragment) {
        mainActivity().replaceFragment(fragment)
    }

    fun goBack() {
        mainActivity().popFragment()
    }

    fun shareItem(text: String, url: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(text, url)
        startActivity(Intent(Intent.createChooser(intent, "Share")))
    }
}