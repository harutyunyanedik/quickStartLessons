package com.example.quickstartlessons.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.adapters.TitleAdapter
import com.example.quickstartlessons.databinding.FragmentRecyclerBinding
import com.example.quickstartlessons.models.RecyclerModel


class RecyclerFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerBinding
    private val adapter = TitleAdapter()
    private val list = mutableListOf<RecyclerModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerBinding.inflate(inflater, container, false)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.rvTitle.adapter = adapter
        binding.rvTitle.layoutManager = LinearLayoutManager(requireContext())
        adapter.updateAdapter(createList())
        adapter.onItemClick = {
            val alertDialogBuilder = AlertDialog.Builder(requireContext())

            alertDialogBuilder.setTitle("Confirmation")
            alertDialogBuilder.setMessage("Are you want to delete this item?")

            alertDialogBuilder.setPositiveButton("OK") { _: DialogInterface, _: Int ->
                list.remove(it)
                adapter.updateAdapter(list)

            }
            alertDialogBuilder.setNegativeButton("Cancel") { _: DialogInterface, _: Int ->

            }

            val alertDialog: AlertDialog = alertDialogBuilder.create()
            if (!alertDialog.isShowing) {
                alertDialog.show()
            }
        }

    }

    private fun createList(): List<RecyclerModel>{
        for (i in 1..100){
            list.add(RecyclerModel("Title $i"))
        }
        return list
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            RecyclerFragment()
    }
}