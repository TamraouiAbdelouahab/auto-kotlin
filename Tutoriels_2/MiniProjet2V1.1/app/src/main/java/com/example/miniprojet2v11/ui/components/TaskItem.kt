package com.example.miniprojet2v11.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miniprojet2v11.model.Task

@Composable
fun TaskItem(task: Task , onToggleComplete: (Task) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(

        ) {
            Text(
                task.description,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }
        Checkbox(
            checked = task.isCompleted,
            onCheckedChange = { onToggleComplete(task) }

        )
    }
}


@Preview(showBackground = true)
@Composable
fun Preveiw()
{
    val task = Task(1,"abdel",false)
    //TaskItem(task,)
}