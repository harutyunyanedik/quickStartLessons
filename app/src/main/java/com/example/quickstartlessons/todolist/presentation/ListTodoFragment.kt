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

class ListTodoFragment : Fragment() {

    private lateinit var binding: FragmentListTodoBinding
    private val adapter = TodoAdapter()
    private val viewModel: TodoViewModel by viewModels()
    private lateinit var todos: java.lang.StringBuilder



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListTodoBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        todos = StringBuilder(requireActivity().getTodo()!!)
        setupViews()
        binding.buttonAdd.setOnClickListener {
            showDialog()
        }
    }

    private fun setupViews() {
        binding.rvTodoList.adapter = adapter
        binding.rvTodoList.layoutManager = LinearLayoutManager(requireContext())
        viewModel.addTodoList(getTodos())
        viewModel.todoList.observe(viewLifecycleOwner) {
            adapter.updateAdapter(it)
        }

    }
    private fun getTodos() : List<Todo>{
        val todoList = mutableListOf<Todo>()
        while (todos.isNotEmpty()){
            val indexOfTodo = todos.indexOf("/")
            val todo = todos.substring(0, indexOfTodo)
            val indexOfTitle = todo.indexOf("+")
            val title =todo.substring(0, indexOfTitle)
            val description = todo.substring(indexOfTitle + 1)
            todoList.add(Todo(title, description))
            todos.delete(0, indexOfTodo + 1)
        }
        return todoList
    }

    private fun showDialog(){
        val dialog = AddTodoFragment{title, description ->
            viewModel.addTodo(Todo(title, description))
            todos.append("$title+$description/")
            requireActivity().putTodo(todos.toString())
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
