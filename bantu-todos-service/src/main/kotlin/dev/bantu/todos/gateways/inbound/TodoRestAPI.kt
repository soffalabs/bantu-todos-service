package dev.bantu.todos.gateways.inbound

import dev.bantu.accounts.api.Accounts
import dev.bantu.todos.api.TodoAPI
import dev.bantu.todos.api.model.*
import dev.bantu.todos.api.operation.AddTodo
import dev.bantu.todos.api.operation.CompleteTodo
import dev.bantu.todos.api.operation.GetTodoList
import dev.bantu.todos.api.operation.UpdateTodo
import io.soffa.foundation.annotations.Authenticated
import io.soffa.foundation.core.RequestContext
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.annotation.security.RolesAllowed
import javax.validation.Valid

@RestController
@RequestMapping(path = ["v1"], produces = [MediaType.APPLICATION_JSON_VALUE])
@Authenticated
@RolesAllowed(Accounts.APP_PERMISSION)
class TodoRestAPI(
    private val getTodoList: GetTodoList,
    private val addTodo: AddTodo,
    private val completeTodo: CompleteTodo,
    private val updateTodo: UpdateTodo,
) : TodoAPI {

    @GetMapping
    override fun todos(context: RequestContext): TodoList = getTodoList.handle(context)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    override fun addTodo(@RequestBody @Valid input: AddTodoInput, context: RequestContext): Todo {
        return addTodo.handle(input, context)
    }

    @PatchMapping("{id}/done")
    override fun completeTodo(@Parameter(hidden = true) input: CompleteTodoInput, context: RequestContext): Todo {
        return completeTodo.handle(input, context)
    }

    @PatchMapping("{id}")
    override fun updateTodo(@PathVariable id: String, @RequestBody @Valid input: UpdateTodoInput, context: RequestContext): Todo {
        input.id = id
        return updateTodo.handle(input, context)
    }
}
