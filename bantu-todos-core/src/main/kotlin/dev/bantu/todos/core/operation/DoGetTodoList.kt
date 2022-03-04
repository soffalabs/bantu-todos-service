package dev.bantu.todos.core.operation

import dev.bantu.todos.api.model.TodoList
import dev.bantu.todos.api.operation.GetTodoList
import dev.bantu.todos.core.data.TodoRepository
import io.soffa.foundation.annotations.Authenticated
import io.soffa.foundation.annotations.TenantRequired
import io.soffa.foundation.core.RequestContext
import javax.inject.Named

@Named
 class DoGetTodoList(private val todos: TodoRepository): GetTodoList {

    @TenantRequired
    @Authenticated
    override fun handle(input: Void?, context: RequestContext): TodoList {
        return TodoList(todos.findAll())
    }

}
