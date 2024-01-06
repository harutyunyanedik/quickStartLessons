package com.example.quickstartlessons.todolist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.DialogAddTodoBinding
import com.example.quickstartlessons.databinding.FragmentListTodoBinding
import com.example.quickstartlessons.todolist.data.Todo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListTodoFragment : Fragment() {

    private lateinit var binding: FragmentListTodoBinding
    private val adapter = TodoAdapter()
    private val viewModel: TodoViewModel by viewModels()
    private lateinit var todos: MutableList<Todo>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListTodoBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        binding.buttonAdd.setOnClickListener {
            showDialog()
        }
    }

    private fun setupViews() {
        binding.rvTodoList.adapter = adapter
        binding.rvTodoList.layoutManager = LinearLayoutManager(requireContext())
        todos = getTodos()
        viewModel.addTodoList(todos)
        viewModel.todoList.observe(viewLifecycleOwner) {
            adapter.updateAdapter(it)
        }

    }

    private fun getTodos(): MutableList<Todo> {
        val json = requireActivity().getTodo()
        val type = object : TypeToken<MutableList<Todo>>() {}.type
        return Gson().fromJson(json, type) ?: mutableListOf()
    }

    private fun showDialog() {
        val dialog = AddTodoFragment { title, description ->
            todos.add(Todo(title, description))
            val convertedTodos = Gson().toJson(todos.toList())
            requireActivity().putTodo(convertedTodos)
            viewModel.addTodoList(todos)
        }
        dialog.show(childFragmentManager, "AddTodoDialog")
    }

}

class AddTodoFragment(private val addTodo: (String, String) -> Unit) : DialogFragment() {

    private lateinit var binding: DialogAddTodoBinding

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        dialog?.let {
            it.window?.setLayout(1000, 1000)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DialogAddTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAddTodo.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val description = binding.editTextDescription.text.toString()
            if (title.isNotEmpty() && description.isNotEmpty()) {
                addTodo.invoke(title, description)
                dialog?.dismiss()
            } else {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
