package dev.bantu.todos.core.operation

import dev.bantu.todos.api.model.CompleteTodoInput
import dev.bantu.todos.api.model.Todo
import dev.bantu.todos.api.operation.CompleteTodo
import dev.bantu.todos.core.data.TodoRepository
import io.soffa.foundation.annotations.Authenticated
import io.soffa.foundation.annotations.TenantRequired
import io.soffa.foundation.context.RequestContext
import io.soffa.foundation.errors.ResourceNotFoundException
import javax.inject.Named

@Named
open class DoCompleteTodo(private val todos: TodoRepository) : CompleteTodo {

    @TenantRequired
    @Authenticated
    override fun handle(input: CompleteTodoInput, context: RequestContext): Todo {
        val todo = todos.findById(input.id!!) ?: throw ResourceNotFoundException("Todo not found")
        if (todo.done == true) {
            return todo;
        }
        todo.done = true
        todos.save(todo)
        return todo
    }

}
