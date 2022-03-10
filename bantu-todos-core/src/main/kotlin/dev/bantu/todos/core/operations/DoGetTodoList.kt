package dev.bantu.todos.core.operations

import dev.bantu.todos.api.operations.GetTodoList
import dev.bantu.todos.api.schema.TodoList
import dev.bantu.todos.ports.data.TodoRepository
import dev.soffa.foundation.annotations.Authenticated
import dev.soffa.foundation.annotations.TenantRequired
import dev.soffa.foundation.context.Context
import javax.inject.Named

@Named
 class DoGetTodoList(private val todos: TodoRepository): GetTodoList {

    @TenantRequired
    @Authenticated
    override fun handle(input: Void?, context: Context): TodoList {
        return TodoList(todos.findAll())
    }

}
