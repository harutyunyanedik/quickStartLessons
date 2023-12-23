package com.example.quickstartlessons.todolist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentAddTodoBinding
import com.example.quickstartlessons.todolist.data.Todo

class AddTodoFragment : Fragment() {

    private lateinit var binding: FragmentAddTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.buttonAddTodo.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val description = binding.editTextDescription.text.toString()
            if (title.isNotEmpty() && description.isNotEmpty()){
                (requireActivity() as MainActivity).viewModel.addTodo(Todo(title, description))
                findNavController().navigate(R.id.action_addTodoFragment_to_listTodoFragment)
            } else {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }


        }
    }

    companion object {
        fun newInstance() =
            AddTodoFragment()
    }
}