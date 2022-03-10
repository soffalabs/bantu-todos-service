package dev.bantu.todos.core.operations

import dev.bantu.todos.api.operations.CompleteTodo
import dev.bantu.todos.api.schema.Todo
import dev.bantu.todos.api.schema.TodoStatus
import dev.bantu.todos.ports.data.TodoRepository
import dev.soffa.foundation.annotations.Authenticated
import dev.soffa.foundation.annotations.TenantRequired
import dev.soffa.foundation.context.Context
import dev.soffa.foundation.errors.ResourceNotFoundException
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
