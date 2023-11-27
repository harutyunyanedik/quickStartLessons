package com.example.quickstartlessons.android.ftagments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.base.BaseFragment

class EmailResetPasswordFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_email_reset_password, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = EmailResetPasswordFragment()
    }
}