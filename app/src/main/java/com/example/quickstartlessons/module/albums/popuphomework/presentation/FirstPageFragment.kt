package com.example.quickstartlessons.module.albums.popuphomework.presentation

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.ItemListBinding
import com.example.quickstartlessons.module.albums.popuphomework.data.ItemsData


class FirstPageFragment : Fragment() {

    private lateinit var binding: ItemListBinding
    private val adapter = ItemsAdapter()
    private val viewModel: ItemsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        binding.buttonAdd.setOnClickListener {
            showDialog()
        }
    }

    private fun setupAdapter() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.itemsList.observe(viewLifecycleOwner) {
            adapter.updateAdapter(it)
        }

    }

    private fun showDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.fragment_first_page)
        val nameTitle: EditText = dialog.findViewById(R.id.nameTitle)
        val surnameTitle: EditText = dialog.findViewById(R.id.surnameTitle)
        val countryTitle: EditText = dialog.findViewById(R.id.countryTitle)
        val addUser: EditText = dialog.findViewById(R.id.addUser)
        addUser.setOnClickListener {
            val name1 = nameTitle.text.toString()
            val surname1 = surnameTitle.text.toString()
            val country1 = countryTitle.text.toString()
            if (name1.isNotEmpty() && surname1.isNotEmpty() && country1.isNotEmpty()) {
                viewModel.add(ItemsData(name1, surname1, country1))
                dialog.dismiss()
            } else {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
        dialog.show()
    }

    companion object {

        fun newInstance() = FirstPageFragment()
    }
}