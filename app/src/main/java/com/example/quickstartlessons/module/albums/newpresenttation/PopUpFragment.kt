package com.example.quickstartlessons.module.albums.newpresenttation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.quickstartlessons.databinding.FragmentPopUpBinding

class PopUpFragment(private var itemTitle: String, private var itemMassage: String): DialogFragment() {
   private lateinit var  binding: FragmentPopUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
   binding = FragmentPopUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editButton.setOnClickListener {
            if (binding.editTitle.text.isEmpty() || binding.editMassage.text.isEmpty()){
                Toast.makeText(requireContext(),"Please fill the empty blanks first",Toast.LENGTH_SHORT).show()
            }else{
                val title = binding.editTitle.text.toString()
                val  massage = binding.editMassage.text.toString()
                itemTitle = title
                itemMassage = massage
                dismiss()
            }
        }
    }



}