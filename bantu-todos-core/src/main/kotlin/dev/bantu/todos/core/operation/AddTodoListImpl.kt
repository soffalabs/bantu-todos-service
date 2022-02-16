package dev.bantu.todos.core.operation

import dev.bantu.todos.api.model.AddTodoInput
import dev.bantu.todos.api.model.Todo
import dev.bantu.todos.api.operation.AddTodo
import dev.bantu.todos.core.data.TodoRepository
import io.soffa.foundation.annotations.Authenticated
import io.soffa.foundation.annotations.TenantRequired
import io.soffa.foundation.commons.IdGenerator
import io.soffa.foundation.context.RequestContext
import java.util.*
import javax.inject.Named

@Named
open class AddTodoListImpl(private val todos: TodoRepository) : AddTodo {

    @TenantRequired
    @Authenticated
    override fun handle(input: AddTodoInput, context: RequestContext): Todo {
        val todo = Todo(
            IdGenerator.shortUUID("t"),
            input.content!!,
            false,
            Date()
        )
        todos.save(todo);
        return todo;
    }

}
