package dev.bantu.todos.core.operation

import dev.bantu.todos.api.model.CompleteTodoInput
import dev.bantu.todos.api.model.Todo
import dev.bantu.todos.api.model.TodoStatus
import dev.bantu.todos.api.operation.CompleteTodo
import dev.bantu.todos.core.data.TodoRepository
import io.soffa.foundation.annotations.Authenticated
import io.soffa.foundation.annotations.TenantRequired
import io.soffa.foundation.core.RequestContext
import io.soffa.foundation.errors.ResourceNotFoundException
import javax.inject.Named

@Named
class DoCompleteTodo(private val todos: TodoRepository) : CompleteTodo {

    @TenantRequired
    @Authenticated
    override fun handle(input: CompleteTodoInput, context: RequestContext): Todo {
        val todo = todos.findById(input.id!!).orElseThrow { ResourceNotFoundException("Todo not found") }
        todo.status = TodoStatus.DONE
        todos.update(todo)
        return todo
    }

}
