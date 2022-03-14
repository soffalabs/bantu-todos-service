package dev.bantu.todos.api.operation

import dev.bantu.todos.api.schema.Todo
import dev.bantu.todos.api.schema.UpdateTodoInput
import dev.soffa.foundation.core.Operation

interface UpdateTodo: Operation<UpdateTodoInput, Todo>
