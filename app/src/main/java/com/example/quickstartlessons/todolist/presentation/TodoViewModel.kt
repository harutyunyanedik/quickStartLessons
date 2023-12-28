package com.example.quickstartlessons.todolist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quickstartlessons.todolist.data.Todo

class TodoViewModel : ViewModel() {

    private val _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>>
        get() = _todoList

    fun addTodo(todo: Todo) {
        if (_todoList.value == null){
            _todoList.value = listOf(todo)
        }else {
            val list = _todoList.value?.toMutableList()
            list?.add(todo)
            _todoList.value = list?.toList()
        }
    }

    fun addTodoList(list: List<Todo>){
        _todoList.value = list
    }
}