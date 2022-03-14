package dev.bantu.todos.api.schema

import java.util.*

data class Todo(
    val id: String? = null,
    var content: String? = null,
    var status: TodoStatus? = null,
    val created: Date? = null
)
