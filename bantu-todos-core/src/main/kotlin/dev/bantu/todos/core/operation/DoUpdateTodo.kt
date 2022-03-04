package dev.bantu.todos.core.operation

import dev.bantu.todos.api.model.Todo
import dev.bantu.todos.api.model.UpdateTodoInput
import dev.bantu.todos.api.operation.UpdateTodo
import dev.bantu.todos.core.data.TodoRepository
import io.soffa.foundation.annotations.Authenticated
import io.soffa.foundation.annotations.TenantRequired
import io.soffa.foundation.core.RequestContext
import io.soffa.foundation.errors.ResourceNotFoundException
import javax.inject.Named

@Named
class DoUpdateTodo(private val todos: TodoRepository) : UpdateTodo {

    @TenantRequired
    @Authenticated
    override fun handle(input: UpdateTodoInput, context: RequestContext): Todo {
        val todo = todos.findById(input.id!!).orElseThrow { ResourceNotFoundException("Todo not found") }
        todo.content = input.content
        todos.update(todo)
        return todo
    }
}
