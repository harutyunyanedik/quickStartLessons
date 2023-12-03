package com.example.quickstartlessons.android.ftagments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.base.BaseFragment
import com.example.quickstartlessons.databinding.FragmentEmailResetPasswordBinding
import com.example.quickstartlessons.databinding.FragmentNewsBinding

class EmailResetPasswordFragment : BaseFragment() {
private lateinit var binding: FragmentEmailResetPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmailResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

          binding.editEmail.text.toString()
        val email = "Your password is reset"
            binding.sendEmail.setOnClickListener{

                Toast.makeText(requireContext(),email,Toast.LENGTH_SHORT).show()

        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = EmailResetPasswordFragment()
    }
}