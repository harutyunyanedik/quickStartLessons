package com.example.quickstartlessons.android.activity.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.android.activity.adapters.ImagesRecyclerViewAdapter
import com.example.quickstartlessons.android.activity.models.Model
import com.example.quickstartlessons.android.base.BaseFragment
import com.example.quickstartlessons.databinding.FragmentImagesBinding

class ImagesFragment : BaseFragment() {

    private lateinit var binding: FragmentImagesBinding
    private var item: MutableList<Model> = mutableListOf()
    private var adapter: ImagesRecyclerViewAdapter = ImagesRecyclerViewAdapter {
        var newItem:MutableList<Model> = mutableListOf()
        showAlertDialog {
            for (i in 0..item.size){
                item.remove(item[i])
                newItem = item
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentImagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupImages()
    }

    private fun setupImages() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        adapter.updateData(createImages())
    }

    private fun createImages(): List<Model> {
        for (i in 0..2) {
            item.add(Model("https://lurer.com/timthumb.php?src=disc/25-09-20/cfb9652534a39cee7eb321763206db77.jpg&w=780"))
        }
        return item
    }

    fun showAlertDialog(onItemClick: (Boolean) -> Unit) {

        val alertDialogBuilder = AlertDialog.Builder(requireContext())

        alertDialogBuilder.setTitle("Completion")
        alertDialogBuilder.setMessage("Delete this image.")
        alertDialogBuilder.setCancelable(false)

        alertDialogBuilder.setPositiveButton("OK") { _: DialogInterface, _: Int ->
            onItemClick.invoke(true)
        }
        alertDialogBuilder.setNegativeButton("Cancel") { _: DialogInterface, _: Int ->
            onItemClick.invoke(false)
        }

        val alertDialog: AlertDialog = alertDialogBuilder.create()
        if (!alertDialog.isShowing) {
            alertDialog.show()
        }
    }

    companion object {
        fun newInstance() = ImagesFragment()
    }
}