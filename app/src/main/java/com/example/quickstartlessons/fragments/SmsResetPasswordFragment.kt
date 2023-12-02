package com.example.quickstartlessons.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.R
import com.example.quickstartlessons.base.BaseFragment

class SmsResetPasswordFragment :BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sms_reset_password, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = SmsResetPasswordFragment()
    }
}