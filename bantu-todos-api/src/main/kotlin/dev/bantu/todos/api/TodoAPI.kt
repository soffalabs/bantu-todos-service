package dev.bantu.todos.api

import dev.bantu.accounts.Accounts
import dev.bantu.todos.api.operations.AddTodo
import dev.bantu.todos.api.operations.CompleteTodo
import dev.bantu.todos.api.operations.GetTodoList
import dev.bantu.todos.api.operations.UpdateTodo
import dev.bantu.todos.api.operations.AddTodoInput
import dev.bantu.todos.api.schema.Todo
import dev.bantu.todos.api.schema.TodoList
import dev.bantu.todos.api.operations.UpdateTodoInput
import dev.soffa.foundation.annotations.Authenticated
import dev.soffa.foundation.annotations.BindOperation
import dev.soffa.foundation.context.Context
import dev.soffa.foundation.openapi.OpenApi
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import javax.annotation.security.RolesAllowed

@Authenticated
@SecurityRequirement(name = OpenApi.BASIC_AUTH)
@RolesAllowed(Accounts.APP_PERMISSION)
interface TodoAPI {

    @Operation(summary = "Retrieve todos linked to your application")
    @BindOperation(GetTodoList::class)
    fun todos(context: Context): TodoList

    @Operation(
        summary = "Add a new todo",
    )
    @BindOperation(AddTodo::class)
    fun addTodo(input: AddTodoInput, context: Context): Todo

    @Operation(
        summary = "Mark todo as DONE",
        parameters = [Parameter(
            name = "id",
            `in` = ParameterIn.PATH,
            description = "Id of the TODO to update",
            example = "t_12345678"
        )]
    )
    @BindOperation(CompleteTodo::class)
    fun completeTodo(id: String, context: Context): Todo

    @Operation(
        summary = "Update a todo",
        parameters = [Parameter(
            name = "id",
            `in` = ParameterIn.PATH,
            description = "Id of the TODO to update",
            example = "t_12345678"
        )]
    )
    @BindOperation(UpdateTodo::class)
    fun updateTodo(id: String, input: UpdateTodoInput, context: Context): Todo

}
