package dev.bantu.todos.api.operations

import dev.bantu.todos.api.schema.Todo
import dev.soffa.foundation.core.Operation

interface UpdateTodo: Operation<UpdateTodoInput, Todo>
