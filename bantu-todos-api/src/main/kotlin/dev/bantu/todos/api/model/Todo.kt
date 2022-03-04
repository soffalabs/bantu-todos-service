package dev.bantu.todos.api.model

import io.soffa.foundation.annotations.Store
import java.util.Date

@Store("todos")
data class Todo(
    val id: String? = null,
    var content: String? = null,
    var status: TodoStatus? = null,
    val created: Date? = null
)
