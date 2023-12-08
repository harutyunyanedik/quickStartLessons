package com.example.quickstartlessons.android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.Model
import com.example.quickstartlessons.android.adapter.AdapterRootFragment
import com.example.quickstartlessons.android.dialogs.showAlertDialog
import com.example.quickstartlessons.databinding.ItemFragmentRootBinding

class RootFragment : Fragment() {
    private lateinit var binding: ItemFragmentRootBinding
    private val list: MutableList<Model> = createNewList().toMutableList()
    private var adapter = AdapterRootFragment {
        showData(it)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemFragmentRootBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

    }


    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter.updateData(list)
    }

    private fun showData(item: Model) {
        showAlertDialog("Confirmation", "Are You delete this item?") { isDelete ->
            if (isDelete) {
                list.remove(item)
                adapter.updateData(list)

            }
        }
    }

    private fun createNewList(): List<Model> {
        val list = mutableListOf<Model>()
        for (i in 0..20) {
            list.add(Model("Title  $i"))

        }
        return list
    }

    companion object {
        fun newInstance() = RootFragment()
    }
}