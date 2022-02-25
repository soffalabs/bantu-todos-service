package dev.bantu.todos.core.operation

import dev.bantu.todos.api.model.TodoStatus
import dev.bantu.todos.api.model.UpdateTodoInput
import dev.bantu.todos.api.operation.UpdateTodo
import dev.bantu.todos.core.data.TodoRepository
import io.soffa.foundation.annotations.Authenticated
import io.soffa.foundation.annotations.TenantRequired
import io.soffa.foundation.core.RequestContext
import io.soffa.foundation.errors.ResourceNotFoundException
import javax.inject.Named

@Named
open class DoUpdateTodo(private val todos: TodoRepository) : UpdateTodo {

    @TenantRequired
    @Authenticated
    override fun handle(input: UpdateTodoInput, context: RequestContext): TodoStatus {
        val todo = todos.findById(input.id!!) ?: throw ResourceNotFoundException("Todo not found")

        todo.content = input.content
        todos.save(todo)
        return TodoStatus(input.id!!, true)
    }

}
