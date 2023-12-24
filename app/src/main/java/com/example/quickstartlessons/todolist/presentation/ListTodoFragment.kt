package com.example.quickstartlessons.todolist.presentation

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentListTodoBinding
import com.example.quickstartlessons.todolist.data.Todo

class ListTodoFragment : Fragment() {

    private lateinit var binding: FragmentListTodoBinding
    private val adapter = TodoAdapter()
    private val viewModel: TodoViewModel by viewModels()


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
            showDialog()
        }
    }

    private fun setupAdapter() {
        binding.rvTodoList.adapter = adapter
        binding.rvTodoList.layoutManager = LinearLayoutManager(requireContext())
        viewModel.todoList.observe(viewLifecycleOwner){
            adapter.updateAdapter(it)
        }

    }

    private fun showDialog(){
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_add_todo)
        val buttonAddTodo: Button = dialog.findViewById(R.id.buttonAddTodo)
        val editTextTitle: EditText = dialog.findViewById(R.id.editTextTitle)
        val editTextDescription: EditText = dialog.findViewById(R.id.editTextDescription)
        buttonAddTodo.setOnClickListener {
            val title = editTextTitle.text.toString()
            val description = editTextDescription.text.toString()
            if (title.isNotEmpty() && description.isNotEmpty()){
                viewModel.addTodo(Todo(title, description))
                dialog.dismiss()
            } else {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
        dialog.show()
    }

    companion object {

        fun newInstance() = ListTodoFragment()
    }
}