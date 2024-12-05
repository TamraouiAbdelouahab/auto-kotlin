package com.example.miniprojet2v11.model

data class Task(
    val id: Int,
    val description: String,
    var isCompleted: Boolean = false
)
