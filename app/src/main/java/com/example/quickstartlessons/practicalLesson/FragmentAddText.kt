package com.example.quickstartlessons.practicalLesson

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.databinding.ItemAddTextBinding


class FragmentAddText : Fragment() {

    private lateinit var binding: ItemAddTextBinding
    private val items: MutableList<AddTextData> = mutableListOf()
    private val adapter = AdapterAddText()
    private val viewModel: AddTextViewModel by viewModels()


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ItemAddTextBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        binding.addButton.setOnClickListener {
            sowPopup()
        }
    }

    private fun sowPopup() {
        val dialog = FragmentDialog {
     items.add(AddTextData(it))
           adapter.updateAdapter(items)
        }
        dialog.show(childFragmentManager, "show dialog")
    }

    private fun observeViewModel() {
        viewModel.liveDataAddText.observe(viewLifecycleOwner) { it->
            adapter.updateAdapter(it)
        }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

}