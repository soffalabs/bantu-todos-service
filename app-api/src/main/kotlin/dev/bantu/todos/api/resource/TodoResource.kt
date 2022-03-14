package dev.bantu.todos.api.resource

import dev.bantu.accounts.Accounts
import dev.bantu.todos.api.operation.AddTodo
import dev.bantu.todos.api.operation.CompleteTodo
import dev.bantu.todos.api.operation.GetTodoList
import dev.bantu.todos.api.operation.UpdateTodo
import dev.bantu.todos.api.schema.AddTodoInput
import dev.bantu.todos.api.schema.Todo
import dev.bantu.todos.api.schema.TodoList
import dev.bantu.todos.api.schema.UpdateTodoInput
import dev.soffa.foundation.annotation.Authenticated
import dev.soffa.foundation.core.Operation.NO_ARG
import dev.soffa.foundation.resource.OpenApi
import dev.soffa.foundation.resource.Resource
import dev.soffa.foundation.resource.invoke
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.annotation.security.RolesAllowed
import javax.validation.Valid

@Authenticated
@SecurityRequirement(name = OpenApi.BASIC_AUTH)
@RolesAllowed(Accounts.APP_PERMISSION)
@RequestMapping("/v1")
@RestController
interface TodoResource : Resource {

    @Operation(
        summary = "Retrieve todos linked to your application"
    )
    @GetMapping
    fun todos(): TodoList = invoke(GetTodoList::class, NO_ARG)

    @Operation(
        method = "POST",
        summary = "Add a new todo",
    )
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    fun addTodo(@RequestBody @Valid input: AddTodoInput): Todo {
        return invoke(AddTodo::class, input)
    }

    @Operation(
        summary = "Mark todo as DONE",
        parameters = [Parameter(
            name = "id",
            `in` = ParameterIn.PATH,
            description = "Id of the TODO to update",
            example = "t_12345678"
        )]
    )
    @PatchMapping("{id}/done")
    fun completeTodo(@PathVariable id: String): Todo {
        return invoke(CompleteTodo::class, id)
    }

    @Operation(
        summary = "Update a todo",
        parameters = [Parameter(
            name = "id",
            `in` = ParameterIn.PATH,
            description = "Id of the TODO to update",
            example = "t_12345678"
        )]
    )
    @PatchMapping("{id}")
    fun updateTodo(@PathVariable id: String, @RequestBody @Valid input: UpdateTodoInput): Todo {
        input.id = id
        return invoke(UpdateTodo::class.java, input)
    }

}
