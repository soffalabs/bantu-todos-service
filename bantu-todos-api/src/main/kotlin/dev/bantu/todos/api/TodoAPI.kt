package dev.bantu.todos.api

import dev.bantu.todos.api.model.*
import dev.bantu.todos.api.operation.AddTodo
import dev.bantu.todos.api.operation.CompleteTodo
import dev.bantu.todos.api.operation.GetTodoList
import dev.bantu.todos.api.operation.UpdateTodo
import io.soffa.foundation.annotations.Authenticated
import io.soffa.foundation.annotations.BindOperation
import io.soffa.foundation.commons.OpenApi
import io.soffa.foundation.core.RequestContext
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import javax.ws.rs.Path

@Authenticated
@SecurityRequirement(name = OpenApi.BASIC_AUTH)
@Path("/todos")
interface TodoAPI {

    @Operation(method = "GET", summary = "Retrieve todos linked to your application")
    @BindOperation(GetTodoList::class)
    fun todos(context: RequestContext): TodoList

    @Operation(method = "POST", summary = "Add a new todo")
    @BindOperation(AddTodo::class)
    fun addTodo(input: AddTodoInput, context: RequestContext): Todo

    @Operation(
        method = "PATCH",
        summary = "Mark todo ask complete",
        parameters = [Parameter(name = "id", `in` = ParameterIn.PATH, description = "Id of the todo to mark complete", example = "t_12345678")]
    )
    @BindOperation(CompleteTodo::class)
    fun completeTodo(input: CompleteTodoInput, context: RequestContext): Todo

    @Operation(
        method = "PATCH",
        summary = "Update a todo task",
        parameters = [Parameter(name = "id", `in` = ParameterIn.PATH, description = "Id of the todo to update", example = "t_12345678")]
    )
    @BindOperation(UpdateTodo::class)
    fun updateTodo(id:String, input: UpdateTodoInput, context: RequestContext): Todo

}
