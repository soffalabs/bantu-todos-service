package dev.bantu.todos.api.schema

import dev.soffa.foundation.annotations.Store
import java.util.Date

@Store("todos")
data class Todo(
    val id: String? = null,
    var content: String? = null,
    var status: TodoStatus? = null,
    val created: Date? = null
)
