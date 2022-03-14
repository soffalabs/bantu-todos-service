package dev.bantu.todos.core.handler

import dev.bantu.todos.api.schema.Todo
import dev.bantu.todos.api.schema.TodoStatus
import dev.bantu.todos.api.operation.CompleteTodo
import dev.bantu.todos.core.port.TodoRepository
import dev.soffa.foundation.annotation.Authenticated
import dev.soffa.foundation.annotation.TenantRequired
import dev.soffa.foundation.context.Context
import dev.soffa.foundation.error.ResourceNotFoundException
import javax.inject.Named

@Named
class DoCompleteTodo(private val todos: TodoRepository) : CompleteTodo {

    @TenantRequired
    @Authenticated
    override fun handle(input: String, context: Context): Todo {
        val todo = todos.findById(input).orElseThrow { ResourceNotFoundException("Todo not found") }
        todo.status = TodoStatus.DONE
        return todos.update(todo)
    }


}
