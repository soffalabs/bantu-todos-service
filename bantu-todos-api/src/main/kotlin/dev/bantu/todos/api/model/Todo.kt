package dev.bantu.todos.api.model

import java.util.*

data class Todo(
    val id: String,
    val content: String,
    val done: Boolean,
    val createdAt: Date
)
