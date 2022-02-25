package dev.bantu.todos.core.operation

import dev.bantu.todos.api.model.AddTodoInput
import dev.bantu.todos.api.model.Todo
import dev.bantu.todos.api.operation.AddTodo
import dev.bantu.todos.core.data.TodoRepository
import io.soffa.foundation.annotations.Authenticated
import io.soffa.foundation.annotations.TenantRequired
import io.soffa.foundation.commons.IdGenerator
import io.soffa.foundation.core.RequestContext
import java.time.Instant
import javax.inject.Named

@Named
open class DoAddTodoList(private val todos: TodoRepository) : AddTodo {

    @TenantRequired
    @Authenticated
    override fun handle(input: AddTodoInput, context: RequestContext): Todo {
        val todo = Todo(
            IdGenerator.shortUUID("t"),
            input.content!!,
            false,
            Instant.now().toEpochMilli()
        )
        todos.save(todo)
        return todo
    }

}
