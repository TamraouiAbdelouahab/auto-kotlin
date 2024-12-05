package com.example.miniprojet2v11.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.miniprojet2v11.model.Task
import com.example.miniprojet2v11.ui.components.TaskInputField
import com.example.miniprojet2v11.ui.components.TaskItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen() {
    var tasks by rememberSaveable { mutableStateOf(listOf<Task>()) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Liste de tâches") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            TaskInputField(onAddTask = { description ->
                tasks = tasks + Task(id = tasks.size + 1, description = description)
            })
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(tasks.size) { index ->
                    TaskItem(
                        task = tasks[index],
                        onToggleComplete = { task ->
                            tasks = tasks.map {
                                if (it.id == task.id) it.copy(isCompleted = !it.isCompleted) else it
                            }
                        }
                    )
                }
            }
            Button(
                onClick = {
                    tasks = tasks.filter { !it.isCompleted }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Supprimer les tâches terminées")
            }
        }
    }
}


@Preview
@Composable
fun Preveiw1()
{
    TaskScreen()
}