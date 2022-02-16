package dev.bantu.todos.api.operation

import dev.bantu.todos.api.model.AddTodoInput
import dev.bantu.todos.api.model.Todo
import io.soffa.foundation.api.Operation

interface AddTodo : Operation<AddTodoInput, Todo>
