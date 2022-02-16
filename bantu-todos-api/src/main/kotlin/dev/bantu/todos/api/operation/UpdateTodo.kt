package dev.bantu.todos.api.operation

import dev.bantu.todos.api.model.AddTodoInput
import dev.bantu.todos.api.model.TodoStatus
import io.soffa.foundation.api.Operation

interface UpdateTodo: Operation<AddTodoInput, TodoStatus>
