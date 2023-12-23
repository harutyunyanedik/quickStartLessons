package com.example.quickstartlessons.todolist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quickstartlessons.todolist.data.Todo

class TodoViewModel : ViewModel() {
    private val _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>>
            get() = _todoList


    fun addTodo(todo: Todo){
        if (_todoList.value != null){
            val list = _todoList.value?.toMutableList()
            list?.let {
                it.add(todo)
                _todoList.value = it
            }
        } else {
            _todoList.value = listOf(todo)
        }


    }
}