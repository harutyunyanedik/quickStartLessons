package com.example.quickstartlessons.android.extensions

import androidx.fragment.app.Fragment
import com.example.quickstartlessons.android.activity.MainActivity

fun Fragment.mainActivity() = requireActivity() as? MainActivity
