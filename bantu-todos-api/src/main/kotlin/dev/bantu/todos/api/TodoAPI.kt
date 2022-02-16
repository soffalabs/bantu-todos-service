package dev.bantu.todos.api

import dev.bantu.todos.api.model.AddTodoInput
import dev.bantu.todos.api.model.Todo
import dev.bantu.todos.api.operation.AddTodo
import dev.bantu.todos.api.operation.GetTodoList
import io.soffa.foundation.annotations.Authenticated
import io.soffa.foundation.annotations.BindOperation
import io.soffa.foundation.api.SecuritySchemes
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import javax.ws.rs.Path

@Authenticated
@SecurityRequirement(name = SecuritySchemes.BASIC_AUTH)
@Path("/todos")
interface TodoAPI {

    @Operation(method = "GET", summary = "Retrieve all todos")
    @BindOperation(GetTodoList::class)
    fun todos(): List<Todo>

    @Operation(method = "POST", summary = "Add a new todo")
    @BindOperation(AddTodo::class)
    fun addTodo(input: AddTodoInput): Todo

}
