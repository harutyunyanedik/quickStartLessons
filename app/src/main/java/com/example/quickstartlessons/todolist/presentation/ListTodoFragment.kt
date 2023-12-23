package com.example.quickstartlessons.todolist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentListTodoBinding

class ListTodoFragment : Fragment() {

    private lateinit var binding: FragmentListTodoBinding
    private val adapter = TodoAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        binding.buttonAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listTodoFragment_to_addTodoFragment)
        }
    }

    private fun setupAdapter() {
        binding.rvTodoList.adapter = adapter
        binding.rvTodoList.layoutManager = LinearLayoutManager(requireContext())
        (requireActivity() as MainActivity).viewModel.todoList.observe(viewLifecycleOwner){
            adapter.updateAdapter(it)
        }

    }

    companion object {

        fun newInstance() = ListTodoFragment()
    }
}