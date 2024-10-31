package com.example.todoapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel



class TodoViewModel : ViewModel() {
    var tasks by mutableStateOf(listOf<TodoItem>())

    fun addTask(name: String) {
        val newTask = TodoItem(name, System.currentTimeMillis().toString()) // Example timestamp
        tasks = tasks + newTask
    }

    fun deleteTask(task: TodoItem) {
        tasks = tasks.filter { it != task } // Corrected filter logic
    }
}
