package com.example.quickstartlessons.extensions

import androidx.fragment.app.Fragment
import com.example.quickstartlessons.MainActivity

fun Fragment.mainActivity() = requireActivity() as? MainActivity


