package dev.bantu.todos.core.handler

import dev.bantu.todos.api.schema.TodoList
import dev.bantu.todos.api.operation.GetTodoList
import dev.bantu.todos.core.port.TodoRepository
import dev.soffa.foundation.annotation.Authenticated
import dev.soffa.foundation.annotation.TenantRequired
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
