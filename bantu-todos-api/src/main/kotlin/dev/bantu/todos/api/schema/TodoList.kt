package dev.bantu.todos.api.schema

data class TodoList(
    val todos: List<Todo> = emptyList()
)
