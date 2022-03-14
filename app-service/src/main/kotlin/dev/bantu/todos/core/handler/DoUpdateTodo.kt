package dev.bantu.todos.core.handler

import dev.bantu.todos.api.schema.Todo
import dev.bantu.todos.api.operation.UpdateTodo
import dev.bantu.todos.api.schema.UpdateTodoInput
import dev.bantu.todos.core.port.TodoRepository
import dev.soffa.foundation.annotation.Authenticated
import dev.soffa.foundation.annotation.TenantRequired
import dev.soffa.foundation.context.Context
import dev.soffa.foundation.error.ResourceNotFoundException
import javax.inject.Named

@Named
class DoUpdateTodo(private val todos: TodoRepository) : UpdateTodo {

    @TenantRequired
    @Authenticated
    override fun handle(input: UpdateTodoInput, context: Context): Todo {
        val todo = todos.findById(input.id!!).orElseThrow { ResourceNotFoundException("Todo not found") }
        todo.content = input.content
        return todos.update(todo)
    }


}
