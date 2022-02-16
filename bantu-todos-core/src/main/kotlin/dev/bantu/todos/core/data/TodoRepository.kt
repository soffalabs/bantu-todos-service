package dev.bantu.todos.core.data

import dev.bantu.todos.api.model.Todo

interface TodoRepository {

    fun save(model: Todo)

    fun findAll(): List<Todo>

}
