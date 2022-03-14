package dev.bantu.todos.core.handler

import dev.bantu.todos.api.operation.AddTodo
import dev.bantu.todos.api.schema.AddTodoInput
import dev.bantu.todos.api.schema.Todo
import dev.bantu.todos.api.schema.TodoStatus
import dev.bantu.todos.core.port.TodoRepository
import dev.soffa.foundation.annotation.Authenticated
import dev.soffa.foundation.annotation.TenantRequired
import dev.soffa.foundation.commons.IdGenerator
import dev.soffa.foundation.context.Context
import java.time.Instant
import java.util.*
import javax.inject.Named

@Named
class DoAddTodo(private val todos: TodoRepository) : AddTodo {

    @TenantRequired
    @Authenticated
    override fun handle(input: AddTodoInput, context: Context): Todo {
        val todo = Todo(
            IdGenerator.shortUUID("t"),
            input.content!!,
            TodoStatus.PENDING,
            Date.from(Instant.now())
        )
        return todos.insert(todo)
    }

}
