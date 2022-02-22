package dev.bantu.todos.api.operation

import dev.bantu.todos.api.model.AddTodoInput
import dev.bantu.todos.api.model.TodoStatus
import io.soffa.foundation.core.Operation

interface UpdateTodo: Operation<AddTodoInput, TodoStatus>
