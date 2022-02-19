package dev.bantu.todos.api.model

data class TodoList(
    val todos: List<Todo> = emptyList()
)
