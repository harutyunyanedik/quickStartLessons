package com.example.quickstartlessons.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.fragment.navArgs
import com.example.quickstartlessons.R
class FragmentNavigate : Fragment() {
private  val args: FragmentNavigateArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          args.photoUrl
        return inflater.inflate(R.layout.fragment_navigate, container, false)
    }

}