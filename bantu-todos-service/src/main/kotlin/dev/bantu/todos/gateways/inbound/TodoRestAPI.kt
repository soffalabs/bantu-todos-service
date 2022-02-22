package dev.bantu.todos.gateways.inbound

import dev.bantu.todos.api.TodoAPI
import dev.bantu.todos.api.model.AddTodoInput
import dev.bantu.todos.api.model.CompleteTodoInput
import dev.bantu.todos.api.model.Todo
import dev.bantu.todos.api.model.TodoList
import dev.bantu.todos.api.operation.AddTodo
import dev.bantu.todos.api.operation.CompleteTodo
import dev.bantu.todos.api.operation.GetTodoList
import dev.bantu.todos.core.App
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
@RolesAllowed(App.ROLE_APPLICATION)
class TodoRestAPI(
    private val getTodoList: GetTodoList,
    private val addTodo: AddTodo,
    private val completeTodo: CompleteTodo,
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


}
