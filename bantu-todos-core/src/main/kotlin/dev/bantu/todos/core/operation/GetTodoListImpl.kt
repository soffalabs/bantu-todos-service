package dev.bantu.todos.core.operation

import dev.bantu.todos.api.model.Todo
import dev.bantu.todos.api.operation.GetTodoList
import dev.bantu.todos.core.data.TodoRepository
import io.soffa.foundation.annotations.Authenticated
import io.soffa.foundation.annotations.TenantRequired
import io.soffa.foundation.context.RequestContext
import javax.inject.Named

@Named
open class GetTodoListImpl(private val todos: TodoRepository): GetTodoList {

    @TenantRequired
    @Authenticated
    override fun handle(input: Void?, context: RequestContext): List<Todo> {
        return todos.findAll();
    }

}
