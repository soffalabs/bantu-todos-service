package dev.bantu.todos.api.operation

import dev.bantu.todos.api.model.Todo
import dev.bantu.todos.api.model.UpdateTodoInput
import io.soffa.foundation.core.Operation

interface UpdateTodo: Operation<UpdateTodoInput, Todo>
