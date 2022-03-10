package dev.bantu.todos.core.operations

import dev.bantu.todos.api.operations.UpdateTodo
import dev.bantu.todos.api.schema.Todo
import dev.bantu.todos.api.operations.UpdateTodoInput
import dev.bantu.todos.ports.data.TodoRepository
import dev.soffa.foundation.annotations.Authenticated
import dev.soffa.foundation.annotations.TenantRequired
import dev.soffa.foundation.context.Context
import dev.soffa.foundation.errors.ResourceNotFoundException
import javax.inject.Named
import javax.validation.Valid

@Named
class DoUpdateTodo(private val todos: TodoRepository) : UpdateTodo {

    @TenantRequired
    @Authenticated
    override fun handle(@Valid input: UpdateTodoInput, context: Context): Todo {
        val todo = todos.findById(input.id!!).orElseThrow { ResourceNotFoundException("Todo not found") }
        todo.content = input.content
        return todos.update(todo)
    }


}
