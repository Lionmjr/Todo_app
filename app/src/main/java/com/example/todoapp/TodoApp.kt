package com.example.todoapp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TodoApp(todoViewModel: TodoViewModel) {
    var taskName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        BasicTextField(
            value = taskName,
            onValueChange = { taskName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                todoViewModel.addTask(taskName)
                taskName = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Task")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(todoViewModel.tasks) { task ->
                TaskItem(
                    task = task,
                    onDelete = { todoViewModel.deleteTask(task) }
                )
            }
        }
    }
}

@Composable
fun TaskItem(task: TodoItem, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = task.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Created at: ${task.createdAt}", style = MaterialTheme.typography.bodySmall)
        }
        Button(onClick = onDelete) {
            Text("Delete")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoAppPreview() {
    val dummyViewModel = TodoViewModel().apply {
        // Add dummy tasks for previewing
        addTask("Sample Task 1")
        addTask("Sample Task 2")
    }
    TodoApp(todoViewModel = dummyViewModel)
}
