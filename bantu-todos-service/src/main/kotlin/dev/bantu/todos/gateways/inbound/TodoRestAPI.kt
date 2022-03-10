package dev.bantu.todos.gateways.inbound

import dev.bantu.todos.api.TodoAPI
import dev.bantu.todos.api.operations.AddTodo
import dev.bantu.todos.api.operations.CompleteTodo
import dev.bantu.todos.api.operations.GetTodoList
import dev.bantu.todos.api.operations.UpdateTodo
import dev.bantu.todos.api.operations.AddTodoInput
import dev.bantu.todos.api.schema.Todo
import dev.bantu.todos.api.operations.UpdateTodoInput
import dev.soffa.foundation.context.Context
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(path = ["v1"], produces = [MediaType.APPLICATION_JSON_VALUE])
class TodoRestAPI(
    val getTodoList: GetTodoList,
    val addTodo: AddTodo,
    val completeTodo: CompleteTodo,
    val updateTodo: UpdateTodo,
) : TodoAPI {

    @GetMapping
    override fun todos(context: Context) =  getTodoList.handle(context)!!

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    override fun addTodo(@RequestBody @Valid input: AddTodoInput, context: Context): Todo {
        return addTodo.handle(input, context)
    }

    @PatchMapping("{id}/done")
    override fun completeTodo(@PathVariable id: String, context: Context): Todo {
        return completeTodo.handle(id, context)
    }

    @PatchMapping("{id}")
    override fun updateTodo(
        @PathVariable id: String,
        @RequestBody @Valid input: UpdateTodoInput,
        context: Context
    ): Todo {
        input.apply { this.id = id }
        return updateTodo.handle(input, context)
    }
}
