package dev.bantu.todos.gateways.inbound

import dev.bantu.todos.api.TodoAPI
import dev.bantu.todos.api.model.AddTodoInput
import dev.bantu.todos.api.model.Todo
import dev.bantu.todos.api.operation.AddTodo
import dev.bantu.todos.api.operation.GetTodoList
import dev.bantu.todos.core.App
import io.soffa.foundation.annotations.Authenticated
import io.soffa.foundation.application.OperationHandler
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.annotation.security.RolesAllowed
import javax.validation.Valid

@RestController
@RequestMapping(path = ["v1"], produces = [MediaType.APPLICATION_JSON_VALUE])
@Authenticated
class TodoRestAPI(private val operations: OperationHandler) : TodoAPI {

    @GetMapping
    @RolesAllowed(App.ROLE_APPLICATION)
    override fun todos(): List<Todo> = operations.handle(GetTodoList::class.java)

    @PostMapping
    @RolesAllowed(App.ROLE_APPLICATION)
    override fun addTodo(@RequestBody @Valid input: AddTodoInput): Todo {
        return operations.handle(AddTodo::class.java, input)
    }


}
