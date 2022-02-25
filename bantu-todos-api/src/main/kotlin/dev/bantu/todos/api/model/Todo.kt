package dev.bantu.todos.api.model

data class Todo(
    val id: String? = null,
    var content: String? = null,
    var done: Boolean? = null,
    val createdAt: Long? = null
)
